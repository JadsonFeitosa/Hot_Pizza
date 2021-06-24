package Teste.TesteIntegracao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import DTO.PizzasDTO;
import controller.ControIngre;
import controller.ControlPizzas;
import model.Ingredientes;
import model.ListaIngred;
import view.ExceptionPizza;

public class TesteIntegracao2 {
	
	private static PizzasDTO pizzaDTO1;
	private static PizzasDTO pizzaDTO2;
	private static ControlPizzas controlPizza;
	private static ListaIngred listaIngre;
	
	
	@BeforeAll
	public static void initAll() {
		pizzaDTO1 = new PizzasDTO();
		pizzaDTO2 = new PizzasDTO();
		listaIngre = new ListaIngred();
		controlPizza = new ControlPizzas();
		
	}
	
	@Rule
	ExpectedException thowns = ExpectedException.none();
	@Test
	public void testeSalvarPizzaSemAtributos() throws ExceptionPizza {
		thowns.expect(ExceptionPizza.class);
		thowns.expectMessage("Pizza já cadastrado !");
		
		controlPizza.salvarPizza(pizzaDTO1);
		
		assertEquals(pizzaDTO1.getCod(), controlPizza.pesquisarPizza(0));
	}
	
	
	@Test
	public  void testAddPizza() throws ExceptionPizza {
		thowns.expect(ExceptionPizza.class);
		thowns.expectMessage("Pizza já cadastrado !");
		
		pizzaDTO1.setCod(2);
		pizzaDTO1.setCusto(10f);
		pizzaDTO1.setPrepara("prepara");
		pizzaDTO1.setNome("nome1");
		pizzaDTO1.setTamnaho("M");
		pizzaDTO1.setValorcomp(5f);
		pizzaDTO1.setQuantft(1);
		pizzaDTO1.setValorft(40f);
		pizzaDTO1.setIngred(listaIngre);
		
		controlPizza.salvarPizza(pizzaDTO1);
		
		assertEquals(pizzaDTO1.getCod(), controlPizza.listaPizzas().getCod() == 2);
		
	}
	
	@Test
	public  void testAddPizzaIgual() throws ExceptionPizza {
		thowns.expect(ExceptionPizza.class);
		thowns.expectMessage("Pizza já cadastrado !");

		pizzaDTO1.setCod(1);
		pizzaDTO1.setCusto(0f);
		pizzaDTO1.setPrepara("");
		pizzaDTO1.setNome("");
		pizzaDTO1.setTamnaho("");
		pizzaDTO1.setValorcomp(0f);
		pizzaDTO1.setQuantft(0);
		pizzaDTO1.setValorft(0f);
		pizzaDTO1.setIngred(listaIngre);
		
		pizzaDTO2.setCod(1);
		pizzaDTO2.setCusto(0f);
		pizzaDTO2.setPrepara("");
		pizzaDTO2.setNome("");
		pizzaDTO2.setTamnaho("");
		pizzaDTO2.setValorcomp(0f);
		pizzaDTO2.setQuantft(0);
		pizzaDTO2.setValorft(0f);
		pizzaDTO2.setIngred(listaIngre);


		
		controlPizza.salvarPizza(pizzaDTO1);
		controlPizza.salvarPizza(pizzaDTO2);
		
		assertEquals(pizzaDTO1.getCod(), pizzaDTO2.getCod());
		
	}
	
	@Test
	public void salvarPizzaSemIngredientes() throws ExceptionPizza {
		thowns.expect(ExceptionPizza.class);
		thowns.expectMessage("Pizzas sem ingredientes!");
		
		pizzaDTO1.setCod(1);
		pizzaDTO1.setCusto(0f);
		pizzaDTO1.setPrepara("");
		pizzaDTO1.setNome("");
		pizzaDTO1.setTamnaho("");
		pizzaDTO1.setValorcomp(0f);
		pizzaDTO1.setQuantft(0);
		
		controlPizza.salvarPizza(pizzaDTO1);
		
		assertEquals(pizzaDTO1.getCod(), controlPizza.listaPizzas().getCod() == 1);
	}
	

	@AfterAll
	public static void tearDownAll() {
		
		
		controlPizza.listaPizzas().getLista().forEach(dados-> System.out.println("Codigo: "+dados.getCod()+
				"Nome: "+dados.getNome() + "Valor: "+ dados.getValorcomp()+"Tamanho: "+dados.getTamnaho()
				));
		
	}
}
