import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {

	/**
	 * Constante que contém o diretório raiz onde o projeto está.
	 */
	private static final String USER_DIR = System.getProperty("user.dir");

	@Test
	public void teste() {

		WebDriver driver = new ChromeDriver();
		driver.get(USER_DIR + "/src/main/resources/componentes.html");

		// driver.quit();

	}

}
