package Teste.TesteUnidade;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import DTO.ClienteDTO;
import DTO.PedidosDTO;
import controller.ControlPedidos;

class TestePedido {

	private static ClienteDTO cliente;
	private static PedidosDTO pedidos;
	private static ControlPedidos controlPedidos;
	
	
	
	@BeforeAll
	public static void initAll() {
		cliente = new ClienteDTO();
    	pedidos = new PedidosDTO();
		controlPedidos = new ControlPedidos();
		
	}

	@Test
	@Disabled
	public static void testePedidoDataInvalida() {
		pedidos.setClientes(cliente);
		pedidos.setCod(1);
		pedidos.setData("50/50/3000");
		pedidos.setPizza("pizza 1");
		pedidos.setQuant(1);
		
		
		controlPedidos.contSalvarPedido(pedidos);
	}
	
	@Test
	void testSalvarPedidoVazio()  {
		pedidos.setClientes(null);
		pedidos.setCod(0);
		pedidos.setData(null);
		
		
		controlPedidos.contSalvarPedido(pedidos);
		
	}
	
	@AfterAll
	public static void tearDownAll() {
		
	}

}
