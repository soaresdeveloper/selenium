import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro {

	/**
	 * Constante que contém o diretório raiz onde o projeto está.
	 */
	private static final String USER_DIR = System.getProperty("user.dir");
	private WebDriver driver = new ChromeDriver();
	private CampoTreinamentoPage page;

	@Parameter(value = 0)
	public String nome;
	@Parameter(value = 1)
	public String sobrenome;
	@Parameter(value = 2)
	public String sexo;
	@Parameter(value = 3)
	public List<String> comidas;
	@Parameter(value = 4)
	public String[] esportes;
	@Parameter(value = 5)
	public String msg;

	@Before
	public void init() {
		driver.get(USER_DIR + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);

	}

	@After
	public void quit() {
		driver.quit();
	}

	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {
			
				// Massa de teste.

				{ "", "", "", Arrays.asList(), new String[] {}, "Nome eh obrigatorio" },
				{ "Lucas", "", "", Arrays.asList(), new String[] {}, "Sobrenome eh obrigatorio" },
				{ "Lucas", "Soares", "", Arrays.asList(), new String[] {}, "Sexo eh obrigatorio" },
				{ "Lucas", "Soares", "Masculino", Arrays.asList("Carne","Vegetariano"), new String[] {}, "Tem certeza que voce eh vegetariano?" },
				{ "Lucas", "Soares", "Masculino", Arrays.asList("Carne","Pizza"), new String[] {"Futebol","O que eh esporte?"}, "Voce faz esporte ou nao?" }
		});
	}

	@Test
	public void validarRegras() {

		page.setNome(nome);
		page.setSobrenome(sobrenome);

		if (sexo.equals("Masculino")) {
			page.setSexoMasculino();
		} else {
			page.setSexoFeminino();
		}
		if (comidas.contains("Carne"))
			page.setComidaCarne();
		if (comidas.contains("Pizza"))
			page.setComidaPizza();
		if (comidas.contains("Frango"))
			page.setComidaFrango();

		page.setEsporte(esportes);

		page.cadastrar();
		System.out.println(msg);
		
		Assert.assertEquals(msg, page.obterTextoAlertEsporte());

	}

}
