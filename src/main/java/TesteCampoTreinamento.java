import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

}
