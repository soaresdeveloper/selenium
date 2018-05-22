import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

	private DSL dsl;

	private static final String CAMPO_NOME = "elementosForm:nome";
	private static final String CAMPO_SOBRENOME = "elementosForm:sobrenome";

	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	public void setNome(String nome) {
		dsl.escrever(CAMPO_NOME, nome);
	}

	public void setSobrenome(String sobrenome) {
		dsl.escrever(CAMPO_SOBRENOME, sobrenome);
	}

	public void setSexoMasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}

	public void setComidaPizza() {
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}

	public void setEscolaridade(String valor) {
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}

	public void setEsporte(String... valores) {
		for (String valor : valores) {
			dsl.selecionarComboByVisibleText("elementosForm:esportes", valor);
		}
	}

	public void setSugestoes(String valor) {
		dsl.escrever("elementosForm:sugestoes", valor);
	}

	public void cadastrar() {
		dsl.clicar("elementosForm:cadastrar");
	}

	public String obterResultadoCadastro() {
		return dsl.obterTexto("resultado");
	}

	public String obterNomeCadastro() {
		return dsl.obterTexto("descNome");
	}

	public String obterSobrenomeCadastro() {
		return dsl.obterTexto("descSobrenome");
	}

	public String obterSexoCadastro() {
		return dsl.obterTexto("descSexo");
	}

	public String obterComidaCadastro() {
		return dsl.obterTexto("descComida");
	}

	public String obterEscolaridadeCadastro() {
		return dsl.obterTexto("descEscolaridade");
	}

	public String obterEsporteCadastro() {
		return dsl.obterTexto("descEsportes");
	}

	public String obterSugestoesCadastro() {
		return dsl.obterTexto("descSugestoes");
	}

	public String obterTextoAlertEsporte() {
		return dsl.obterTextoAlertEsporte();
	}

}
