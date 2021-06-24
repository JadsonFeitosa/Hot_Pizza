package DTO;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import DTO.PizzasDTO;
import controller.ControIngre;
import controller.ControlPizzas;
import model.Ingredientes;
import model.ListaIngred;
import view.ExceptionPizza;

public class TestePizza {
	
	private static PizzasDTO pizza1;
	private static PizzasDTO pizza2;
	private static Ingredientes ingredientes;
	private static ControlPizzas contPizza;
	private static ControIngre contIn;
	private static ListaIngred listaIngre;
	
	
	@BeforeAll
	public static void initAll() {
		pizza1 = new PizzasDTO();
		pizza2 = new PizzasDTO();
		ingredientes = new Ingredientes();
		listaIngre = new ListaIngred();
		contIn = new ControIngre();
		contPizza = new ControlPizzas();
		
	}
	
	@Rule
	ExpectedException thowns = ExpectedException.none();

	
	@Test
	public void testeSalvarPizzavazia() throws ExceptionPizza {
		thowns.expect(ExceptionPizza.class);
		thowns.expectMessage("Pizza já cadastrado !");
		
		contPizza.salvarPizza(pizza1);
	}
	
	
	@Test
	public  void testAddPizza() throws ExceptionPizza {
		thowns.expect(ExceptionPizza.class);
		thowns.expectMessage("Pizza já cadastrado !");
		
		pizza1.setCod(2);
		pizza1.setCusto(10f);
		pizza1.setPrepara("prepara");
		pizza1.setNome("nome1");
		pizza1.setTamnaho("M");
		pizza1.setValorcomp(5f);
		pizza1.setQuantft(1);
		pizza1.setValorft(40f);
		pizza1.setIngred(listaIngre);
		
		contPizza.salvarPizza(pizza1);
	}
	
	@Test
	public  void testAddPizzaIgual() throws ExceptionPizza {
		thowns.expect(ExceptionPizza.class);
		thowns.expectMessage("Pizza já cadastrado !");

		pizza1.setCod(1);
		pizza1.setCusto(0f);
		pizza1.setPrepara("");
		pizza1.setNome("");
		pizza1.setTamnaho("");
		pizza1.setValorcomp(0f);
		pizza1.setQuantft(0);
		pizza1.setValorft(0f);
		pizza1.setIngred(listaIngre);
		
		pizza2.setCod(1);
		pizza2.setCusto(0f);
		pizza2.setPrepara("");
		pizza2.setNome("");
		pizza2.setTamnaho("");
		pizza2.setValorcomp(0f);
		pizza2.setQuantft(0);
		pizza2.setValorft(0f);
		pizza2.setIngred(listaIngre);


		
		contPizza.salvarPizza(pizza1);
		contPizza.salvarPizza(pizza2);
		
	}
	
	@Test
	public void salvarPizzaSemIngredientes() throws ExceptionPizza {
		thowns.expect(ExceptionPizza.class);
		thowns.expectMessage("Pizzas sem ingredientes!");
		
		pizza1.setCod(1);
		pizza1.setCusto(0f);
//		pizza1.setIngred();
		pizza1.setPrepara("");
		pizza1.setNome("");
		pizza1.setTamnaho("");
		pizza1.setValorcomp(0f);
		pizza1.setQuantft(0);
		
		contPizza.salvarPizza(pizza1);
	}
	

	@AfterAll
	public static void tearDownAll() {
		
		
		contPizza.listaPizzas().getLista().forEach(dados-> System.out.println("Codigo: "+dados.getCod()+
				"Nome: "+dados.getNome() + "Valor: "+ dados.getValorcomp()+"Tamanho: "+dados.getTamnaho()
				));
		
//		for (int i = 0; i < contPizza.listaPizzas().getLista().size(); i++) {
//			contPizza.ExcluirPizza(i);
//			
//		}
	}
}
