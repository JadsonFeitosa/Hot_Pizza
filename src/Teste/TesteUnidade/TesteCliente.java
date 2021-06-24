package Teste.TesteUnidade;


import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import DTO.ClienteDTO;
import DTO.PedidosDTO;
import controller.ControlCliente;
import controller.ControlPedidos;
import view.ExceptionCliente;
import view.ExceptionPizza;


class TesteCliente {
	
	
	private static ClienteDTO cliente1;
	private static ClienteDTO cliente2;
	private static ControlCliente controlCliente;
	private static PedidosDTO pedidos;
	private static ControlPedidos controlPedidos;
	
	
	
	@BeforeAll
	public static void initAll() {
		cliente1 = new ClienteDTO();
		controlCliente = new ControlCliente();
		pedidos = new PedidosDTO();
		controlPedidos = new ControlPedidos();
		
	}

	@Rule
	ExpectedException thowns = ExpectedException.none();
	@Test
	void testSalvarClienteVazio() throws ExceptionCliente {
		thowns.expect(ExceptionCliente.class);
		thowns.expectMessage("CPF já cadastrado !");
		
		
		cliente1.setCPF("");
		cliente1.setCod(0);
		cliente1.setEnd("");
		cliente1.setNome("");
		cliente1.setTelefone("");
		
		controlCliente.contClienteSave(cliente1);
		
		
	}
	@Test
	void testSalvarClienteCPFInvalido() throws ExceptionCliente {
		thowns.expect(ExceptionCliente.class);
		thowns.expectMessage("CPF já cadastrado!");
		
		
		cliente1.setCPF("aaaaaaaaaaaa");
		cliente1.setCod(1);
		cliente1.setEnd("end 1");
		cliente1.setNome("nome 1");
		cliente1.setTelefone("99999");
		
		controlCliente.contClienteSave(cliente1);
		
		
	}
	@Test
	void testSalvarClienteDuplicado() throws ExceptionCliente {
		thowns.expect(ExceptionPizza.class);
		thowns.expectMessage("CPF já cadastrado !");
		
		
		cliente1.setCPF("000");
		cliente1.setCod(3);
		cliente1.setEnd("end 3");
		cliente1.setNome("nome 3");
		cliente1.setTelefone("33333");
		

		cliente2.setCPF("000");
		cliente2.setCod(3);
		cliente2.setEnd("end 3");
		cliente2.setNome("nome 3");
		cliente2.setTelefone("33333");
		
		controlCliente.contClienteSave(cliente1);
		controlCliente.contClienteSave(cliente2);
		
		
	}
	
	@Test
	public static void pedidoSemCliente() {
		
		pedidos.setClientes(null);
		pedidos.setCod(0);
		pedidos.setData("12/12/2021");
		pedidos.setQuant(1);
		pedidos.setTam("m");
		pedidos.setValor(0);
		
		
		controlPedidos.contSalvarPedido(pedidos);
	}
	
	@AfterAll
	public static void tearDownAll() {
		
		
		controlCliente.listaClientes().getLista().forEach(dados-> System.out.println(
				"Codigo: "+dados.getCod()+ " CPF: " + dados.getCPF() + " Nome: " + dados.getNome()
				));
	}
}
