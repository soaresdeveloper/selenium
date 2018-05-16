import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

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
	public void testeTextField() {

		WebElement txtNome = driver.findElement(By.id("elementosForm:nome"));
		txtNome.sendKeys("Teste de escrita");

		Assert.assertEquals("Teste de escrita", txtNome.getAttribute("value"));

		driver.quit();

	}

	@Test
	public void deveInteragirComTextArea() {

		WebElement txtSugestoes = driver.findElement(By.id("elementosForm:sugestoes"));
		txtSugestoes.sendKeys("teste");

		Assert.assertEquals("teste", txtSugestoes.getAttribute("value"));

		driver.quit();
	}

	@Test
	public void deveInteragirComRadioButton() {

		WebElement radioMasculino = driver.findElement(By.id("elementosForm:sexo:0"));
		radioMasculino.click();

		/**
		 * verifica se o radio button está selecionado.
		 */
		Assert.assertTrue(radioMasculino.isSelected());

		driver.quit();
	}

	@Test
	public void deveInteragirComCheckBox() {

		WebElement checkComida = driver.findElement(By.id("elementosForm:comidaFavorita:2"));
		checkComida.click();

		/**
		 * verifica se o check box está selecionado.
		 */
		Assert.assertTrue(checkComida.isSelected());

		driver.quit();
	}

	@Test
	public void deveInteragirComComboBox() {

		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);

		/**
		 * Seleciona o combo por index, valor ou texto visivel (label).
		 * combo.selectByValue("superior"); combo.selectByIndex(4);
		 * 
		 */

		combo.selectByVisibleText("Mestrado");

		Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());

		driver.quit();
	}

	@Test
	public void deveVerificarValoresComboBox() {

		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);

		/**
		 * Retorna todas as opções de um combo.
		 */
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());

		boolean encontrou = false;
		for (WebElement option : options) {
			if (option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}

		Assert.assertTrue(encontrou);
		driver.quit();
	}

	@Test
	public void deveVerificarValoresComboMultiplo() {

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);

		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");

		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());

		// Desmarcar opção.
		combo.deselectByVisibleText("O que eh esporte?");

		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());

		driver.quit();
	}

}
