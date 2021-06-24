package Teste.TesteIntegracao;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import controller.ControlEmpresa;
import model.Empresa;

public class TesteIntegracao {
	
	private static Empresa empresa;
	private static ControlEmpresa controlEmpresa;
	
	
	@BeforeAll
	public static void initAll() {
		controlEmpresa = new ControlEmpresa();
		empresa = new Empresa();
	}
	
	@Test
	public void testeAdicionarEmpresa() {
		empresa.setCNPJ("121212");
		empresa.setNome("USE Casual");
		empresa.setCidade("Monteiro");
		empresa.setEnd("End 1");
		empresa.setTel("989898989");
		empresa.setCep("5675675");
		empresa.setBairro("novo");
		
		controlEmpresa.salvarEmpresa(empresa);
		
		assertEquals(empresa.getCNPJ(), ControlEmpresa.retEmpresa().getCNPJ() == "121212");
		
	}
	
	@Test
	public void testeAdicionarComValoresNull() {
		empresa.setCNPJ(null);
		empresa.setNome(null);
		empresa.setCidade(null);
		empresa.setEnd(null);
		empresa.setTel(null);
		empresa.setCep(null);
		empresa.setBairro(null);
		
		controlEmpresa.salvarEmpresa(empresa);
		
		assertEquals(empresa.getCNPJ() , controlEmpresa.retEmpresa().getCNPJ());
		
	}
	
	@AfterAll
	public static void tearDownAll() {
		
		System.out.println("Lista Empresa ##################");
		System.out.println(ControlEmpresa.retEmpresa().getCNPJ());
		
	}
}
