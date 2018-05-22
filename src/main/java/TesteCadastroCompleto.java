import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastroCompleto {

	/**
	 * Constante que contém o diretório raiz onde o projeto está.
	 */
	private static final String USER_DIR = System.getProperty("user.dir");
	private WebDriver driver = new ChromeDriver();
	private CampoTreinamentoPage page;

	private String nome = "Lucas";
	private String sobrenome = "Soares";
	private String sexo = "Masculino";
	private String comida = "Pizza";
	private String escolaridade = "2graucomp";
	private String esporte = "Futebol Corrida";

	@Before
	public void init() {
		driver.get(USER_DIR + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);

	}

	@Test
	public void cadastrar() {

		page.setNome(nome);
		page.setSobrenome(sobrenome);
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade(escolaridade);
		page.setEsporte("Futebol", "Corrida");

		page.cadastrar();

		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith(nome));
		Assert.assertEquals("Sobrenome: " + sobrenome, page.obterSobrenomeCadastro());
		Assert.assertEquals("Sexo: " + sexo, page.obterSexoCadastro());
		Assert.assertEquals("Comida: " + comida, page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: " + escolaridade, page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: " + esporte, page.obterEsporteCadastro());

	}

	@Test
	public void verificaEsportes() {

		page.setNome(nome);
		page.setSobrenome(sobrenome);
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade(escolaridade);
		page.setEsporte("Futebol", "Corrida", "O que eh esporte?");
		page.cadastrar();

		Assert.assertEquals("Voce faz esporte ou nao?", page.obterTextoAlertEsporte());

	}

	@After
	public void quit() {
		driver.quit();
	}

}
