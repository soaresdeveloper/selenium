import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

	@Test
	public void teste() {

		// System.setProperty("webdriver.gecko.driver", "C:\\\\Java\\\\testes-automatizados\\\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		

		Assert.assertEquals("Google", driver.getTitle());
		
		/**
		 * fecha todas as abas e mata o processo do driver.
		 */
		driver.quit();
	}

}
