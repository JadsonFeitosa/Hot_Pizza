package controller;

import DTO.ClienteDTO;
import DTO.PedidosDTO;
import DTO.PizzasDTO;
import view.ExceptionCliente;
import view.ExceptionPizza;

public class SistemaFacadePedido {
	
	protected ControlPedidos pedidos;
	protected ControlCliente clientes;
	protected ControlPizzas pizza;
	
	public SistemaFacadePedido() {
		pedidos = new ControlPedidos();
		clientes = new ControlCliente();
		pizza  = new ControlPizzas();
	}
	
	//codigo de modelaagem pra Clientes
	public ClienteDTO buscaCLiente(int c) {
		
		return clientes.contConsultarCliente(c);
	}
	public ClienteDTO listaCliente() {
		return ControlCliente.listaClientes();
	}
	public void salvarCliente(ClienteDTO novo) throws ExceptionCliente {
		clientes.contClienteSave(novo);
		
	}
	public void editarCliente(ClienteDTO editado){
		ControlCliente.conteditarClienteEdite(editado);
		
	}
	public void excluirCliente(int id) {
         ControlCliente.contExcluirClienteDelete(id); 		
	}
	
	
	
	
	
	
	//codigo de modelaagem pra  Pedido
	public String dataPed() {
		return ControlPedidos.dataDoDia();
	}
	public void salvarPedido(PedidosDTO novo) {
		ControlPedidos.contSalvarPedido(novo);
		
	}
	public void editarPedido(PedidosDTO editado) {
		ControlPedidos.conteditarPedido(editado);
	}
	public void excluirPedido(int id) {
		ControlPedidos.contExcluirPedido(id);
		
	}
	public PedidosDTO buscarPedido(int id) {
		return ControlPedidos.retPedido(id);
	}
	public PedidosDTO listaPedido() {
		return ControlPedidos.pesPedido();
	}
	
	
	
	
	
	//codigo de modelaagem pra Pizza
	public PizzasDTO buscarPizza(int p) {
		return pizza.pesquisarPizza(p);
	}
	public PizzasDTO listaPizza() {
		return pizza.listaPizzas();
	}
	public void salvarPizza(PizzasDTO novo) throws ExceptionPizza {
		pizza.salvarPizza(novo);
	}
	public void editarPizza(PizzasDTO editado) {
		pizza.editarPizza(editado);
		
	}
	public void excluirPizza(int id) {
		pizza.ExcluirPizza(id);
	}
	
	

}
