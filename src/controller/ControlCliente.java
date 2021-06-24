package controller;

import DTO.ClienteDTO;
import model.Clientes;
import view.ExceptionCliente;
import view.ExceptionClienteN;


public class ControlCliente {
	
	public void contClienteSave(ClienteDTO novo) throws ExceptionCliente {
	
		Clientes.salvarClientes(novo);
			   
			
		}
	public static void conteditarClienteEdite(ClienteDTO editado){
		
		Clientes.editarClientes(editado);
	}
		
	
	// metodo excluir
	public static void contExcluirClienteDelete(int index){
		
		Clientes.excluirClientes(index);
	
	}
	
	public static ClienteDTO  contConsultarCliente(int cod){
		
		 ClienteDTO c = new ClienteDTO ();
		
		try {
		  c=Clientes.pesquisarClientes(cod);
			
		} catch (ExceptionClienteN e) {
			
		}
		return c;
	
	}
	public static int contIdCliente() {
		
		return Clientes.idCliente();
		
	}
	public static ClienteDTO listaClientes(){
		return Clientes.getlistacli();
	}
	
	
}


