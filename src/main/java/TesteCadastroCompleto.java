import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastroCompleto {

	/**
	 * Constante que contém o diretório raiz onde o projeto está.
	 */
	private static final String USER_DIR = System.getProperty("user.dir");
	private WebDriver driver = new ChromeDriver();
	private DSL dsl = new DSL(driver);

	@Before
	public void init() {
		driver.get(USER_DIR + "/src/main/resources/componentes.html");

	}

	@Test
	public void cadastrar() {

		String nome = "Lucas";
		String sobrenome = "Soares";
		String sexo = "Masculino";
		String comida = "Pizza";
		String escolaridade = "2graucomp";
		String esporte = "Futebol Corrida";
		String sugestoes = "Teste";

		// seta nome.
		dsl.escrever("elementosForm:nome", nome);
		// seta sobrenome.
		dsl.escrever("elementosForm:sobrenome", sobrenome);
		// seleciona radio button sexo e verifica se foi selecionado.
		dsl.clicarRadio("elementosForm:sexo:0");
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		// seleciona checkbox comida.
		dsl.clicarRadio("elementosForm:comidaFavorita:2");

		// seleciona escolaridade.
		dsl.selecionarCombo("elementosForm:escolaridade", escolaridade);

		// seleciona esportes.

		dsl.selecionarComboByVisibleText("elementosForm:esportes", "Futebol");
		dsl.selecionarComboByVisibleText("elementosForm:esportes", "Corrida");

		// escreve sugestoes.
		dsl.escrever("elementosForm:sugestoes", sugestoes);

		// cadastra.
		dsl.clicar("elementosForm:cadastrar");

		WebElement divResultado = dsl.obterElementoPorId("resultado");
		Assert.assertEquals("Cadastrado!", divResultado.findElement(By.tagName("span")).getText());

		Assert.assertEquals("Nome: " + nome, dsl.obterTexto("descNome"));
		Assert.assertEquals("Sobrenome: " + sobrenome, dsl.obterTexto("descSobrenome"));
		Assert.assertEquals("Sexo: " + sexo, dsl.obterTexto("descSexo"));
		Assert.assertEquals("Comida: " + comida, dsl.obterTexto("descComida"));
		Assert.assertEquals("Escolaridade: " + escolaridade, dsl.obterTexto("descEscolaridade"));
		Assert.assertEquals("Esportes: " + esporte, dsl.obterTexto("descEsportes"));
		Assert.assertEquals("Sugestoes: " + sugestoes, dsl.obterTexto("descSugestoes"));

	}

	@After
	public void quit() {
		driver.quit();
	}

}
