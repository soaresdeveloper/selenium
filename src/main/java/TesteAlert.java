import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

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
	public void deveInteragirComAlertSimples() {

		WebElement alert = driver.findElement(By.id("alert"));
		alert.click();

		/**
		 * Altera o foco para o alerta.
		 */

		Alert alertDialog = driver.switchTo().alert();
		String alertText = alertDialog.getText();
		Assert.assertEquals("Alert Simples", alertText);

		/**
		 * Aceita o alerta.
		 */
		alertDialog.accept();

		WebElement txtNome = driver.findElement(By.id("elementosForm:nome"));
		txtNome.sendKeys(alertText);
	}

	@After
	public void quit() {
		driver.quit();
	}

}
