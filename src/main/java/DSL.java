import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {

	private WebDriver driver;

	public DSL(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void escrever(String idCampo, String texto) {
		driver.findElement(By.id(idCampo)).sendKeys(texto);
	}

	public String obterValorCampo(String idCampo) {
		return driver.findElement(By.id(idCampo)).getAttribute("value");
	}

}
