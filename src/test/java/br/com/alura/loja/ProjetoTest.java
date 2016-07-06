package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ARCE - Davi Mustafa
 * @date 06/07/2016
 */
public class ProjetoTest {
	
	@Test
	public void testaQueAConexaoComOServidorFunciona(){
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/projetos");
		String conteudo = target.path("/projetos").request().get(String.class);
		
		Assert.assertTrue(conteudo.contains("<nome>Minha loja"));
	}
}
