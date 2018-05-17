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

	@Test
	public void deveInteragirComAlertConfirm() {

		WebElement btnConfirm = driver.findElement(By.id("confirm"));
		btnConfirm.click();

		// Altera o foco para o alert.
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());

		// Aceita alerta.
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();

		btnConfirm.click();
		alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		// Cancela alerta.
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.accept();
	}

	@Test
	public void deveInteragirComAlertPrompt() {

		WebElement btnPrompt = driver.findElement(By.id("prompt"));
		btnPrompt.click();

		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		
		String texto = "Teste";
		alert.sendKeys(texto);
		alert.accept();

		Assert.assertTrue(alert.getText().contains(texto));
		alert.accept();

		Assert.assertEquals(":D", alert.getText());
		alert.accept();

	}

	@After
	public void quit() {
		driver.quit();
	}

}
