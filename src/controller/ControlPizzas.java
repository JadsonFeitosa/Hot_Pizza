package controller;

import java.util.ArrayList;

import DTO.PizzasDTO;
import model.Ingredientes;

import model.Pizzas;
import view.ExceptionIngre;
import view.ExceptionPizza;


public class ControlPizzas {
	private ArrayList<Ingredientes> lista1 = new ArrayList<>();

	public void addListaIngre(int cod, String nome, float preco,float quant) {
		Ingredientes igre =new Ingredientes();
		igre.setCod(cod);
		igre.setNome(nome);
		igre.setPreco(preco);
		igre.setQunat(quant);
		lista1.add(igre);
		
	}
	

public void  salvarPizza(PizzasDTO novo) throws ExceptionPizza {
		
		
		Pizzas.salvarPizza(novo);
		
		
}
//metodo editar 
	public void editarPizza(PizzasDTO novo){
		
		Pizzas.editarPizza(novo);
		
			
		
	}
	
	// metodo excluir
	public static void ExcluirPizza(int index){
		
		Pizzas.excluirPizza(index);
		
	}
	
	public static PizzasDTO pesquisarPizza(int cod){
		return Pizzas.pesPizza(cod);
		
	}
	
	public static int idPizzas() {
		return Pizzas.idPizza();
	}
	
	public static PizzasDTO listaPizzas(){
		return Pizzas.listaPizza();
	}
	
}
	