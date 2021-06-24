package Teste.TesteIntegracao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import DTO.ClienteDTO;
import DTO.PedidosDTO;
import controller.ControlCliente;
import controller.ControlPedidos;
import view.ExceptionCliente;

public class TesteIntegracao1 {
	
	private static ControlCliente controlCliente;
	private static ControlPedidos controlPedido;
	private static ClienteDTO clienteDTO;
	private static PedidosDTO pedidoDTO;
	
	
	@BeforeAll
	public static void initAll() {
		controlCliente = new ControlCliente();
		clienteDTO = new ClienteDTO();
		pedidoDTO = new PedidosDTO();
	}
	
	@Rule
	ExpectedException thowns = ExpectedException.none();
	@Test
	public void testeAdicionarClienteAoPedido() throws ExceptionCliente {
		thowns.expect(ExceptionCliente.class);
		thowns.expectMessage("Cliente não tem Pedido !");
		
		clienteDTO.setCod(4);
		clienteDTO.setNome("fulano");
		clienteDTO.setCPF("343434");
		controlCliente.contClienteSave(clienteDTO);
		
		pedidoDTO.setClientes(clienteDTO);
		pedidoDTO.setStatus("Teste Aceito");
		controlPedido.contSalvarPedido(pedidoDTO);
		
		assertEquals(controlCliente.listaClientes().getCod() == 4 , pedidoDTO.getClientes().getCod());

	}
	
	
	@Test
	public void testeAdicionarPedidoSemPizzaECliente() {
		pedidoDTO.setCod(2);
		pedidoDTO.setStatus("Não deve ser aceito");
		pedidoDTO.setValor(50f);
		
		controlPedido.contSalvarPedido(pedidoDTO);
		
		assertEquals(pedidoDTO.getCod(), controlPedido.pesPedido().getCod() == 2);
		
		
		
	}

	@Test
	public void testeAdicionarPedidoSemPizza() {
		pedidoDTO.setCod(3);
		pedidoDTO.setStatus("Não deve ser aceito");
		pedidoDTO.setValor(50f);
		pedidoDTO.setClientes(clienteDTO);
		
		controlPedido.contSalvarPedido(pedidoDTO);
		
		assertEquals(pedidoDTO.getCod(), controlPedido.pesPedido().getCod() == 3);
		
	}
	

	@AfterAll
	public static void tearDownAll() {
		
		System.out.println("Listar Clientes ##################");
		ControlCliente.listaClientes().getLista().forEach(dados-> System.out.println(
		"Codigo: "+dados.getCod()+ " CPF: " + dados.getCPF() + " Nome: " + dados.getNome()
		));
		
		
		System.out.println("Listar Pedidos ###################");
		ControlPedidos.pesPedido().getListaPedidos().forEach(dados-> System.out.println(
				"Codigo: "+dados.getCod()+ " Cliente: " + dados.getClientes().getCod() + " Pizza: " + dados.getPizza()
		));
		
	}
}
