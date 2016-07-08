package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.modelo.Projeto;

/**
 * @author ARCE - Davi Mustafa
 * @date 06/07/2016
 */
public class ProjetoTest {
	
	private HttpServer server;
	private Client client;
	private WebTarget target;
	private ClientConfig config;
	
	@Before
	public void startaServidor(){
		server = Servidor.inicializaServidor();
		this.config = new ClientConfig();
		this.config.register(new LoggingFilter());
		this.client = ClientBuilder.newClient(config);
		this.target = client.target("http://localhost:8080");
	}
	
	@After
	public void mataServidor(){
		server.stop();
	}
	
	@Test
	public void testaQueAConexaoComOServidorFunciona(){
		Projeto projeto = target.path("/projetos/1").request().get(Projeto.class);
		Assert.assertEquals("Minha loja", projeto.getNome());
	}
}
