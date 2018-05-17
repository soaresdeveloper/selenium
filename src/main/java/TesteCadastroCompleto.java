import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastroCompleto {

	/**
	 * Constante que contém o diretório raiz onde o projeto está.
	 */
	private static final String USER_DIR = System.getProperty("user.dir");
	private WebDriver driver = new ChromeDriver();

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
		driver.findElement(By.id("elementosForm:nome")).sendKeys(nome);
		// seta sobrenome.
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys(sobrenome);
		// seleciona radio button sexo e verifica se foi selecionado.
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		// seleciona checkbox comida.
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

		// seleciona escolaridade.
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByValue(escolaridade);
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());

		// seleciona esportes.
		WebElement elementEsporte = driver.findElement(By.id("elementosForm:esportes"));
		Select comboEsporte = new Select(elementEsporte);

		comboEsporte.selectByVisibleText("Futebol");
		comboEsporte.selectByVisibleText("Corrida");

		List<WebElement> allSelectedOptions = comboEsporte.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());

		// escreve sugestoes.
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(sugestoes);

		// cadastra.
		driver.findElement(By.id("elementosForm:cadastrar")).click();

		WebElement divResultado = driver.findElement(By.id("resultado"));
		Assert.assertEquals("Cadastrado!", divResultado.findElement(By.tagName("span")).getText());

		Assert.assertEquals("Nome: " + nome, divResultado.findElement(By.id("descNome")).getText());
		Assert.assertEquals("Sobrenome: " + sobrenome, divResultado.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: " + sexo, divResultado.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: " + comida, divResultado.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: " + escolaridade,
				divResultado.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: " + esporte, divResultado.findElement(By.id("descEsportes")).getText());
		Assert.assertEquals("Sugestoes: " + sugestoes, divResultado.findElement(By.id("descSugestoes")).getText());

	}

	@After
	public void quit() {
		driver.quit();
	}

}
