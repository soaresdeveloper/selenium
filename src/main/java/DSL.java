import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	private WebDriver driver;

	public DSL(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void escrever(String idCampo, String texto) {
		driver.findElement(By.id(idCampo)).clear();
		driver.findElement(By.id(idCampo)).sendKeys(texto);
	}

	public String obterValorCampo(String idCampo) {
		return driver.findElement(By.id(idCampo)).getAttribute("value");
	}

	public void clicarRadio(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void clicar(String id) {
		driver.findElement(By.id(id)).click();
	}

	public boolean isRadioMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}

	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByValue(valor);
	}

	public void selecionarComboByVisibleText(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public String obterTexto(String id) {
		return driver.findElement(By.id(id)).getText();
	}

	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}

	public WebElement obterElementoPorId(String id) {
		return driver.findElement(By.id(id));
	}

	public String obterTextoAlertEsporte() {
		return driver.switchTo().alert().getText();
	}

	/***************************** JS *************************************/

	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(cmd, param);
	}
}
