import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

	private DSL dsl;

	private  String nomeId = "elementosForm:nome";
	private  String sobrenomeId = "elementosForm:sobrenome";
	private  String sexoMasculinoId = "elementosForm:sexo:0";
	private  String sexoFemininoId = "elementosForm:sexo:1";
	private  String comidaCarneId = "elementosForm:comidaFavorita:0";
	private  String comidaFrangoId = "elementosForm:comidaFavorita:1";
	private  String comidaPizzaId = "elementosForm:comidaFavorita:2";
	private  String comidaVegetarianaId = "elementosForm:comidaFavorita:3";
	private  String comboEscolaridadeId = "elementosForm:escolaridade";
	private  String comboEsportesId = "elementosForm:esportes";
	private  String sugestoesId = "elementosForm:sugestoes";
	private  String btnCadastrarId = "elementosForm:cadastrar";

	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	public void setNome(String nome) {
		dsl.escrever(nomeId, nome);
	}

	public void setSobrenome(String sobrenome) {
		dsl.escrever(sobrenomeId, sobrenome);
	}

	public void setSexoMasculino() {
		dsl.clicarRadio(sexoMasculinoId);
	}

	public void setSexoFeminino() {
		dsl.clicarRadio(sexoFemininoId);
	}

	public void setComidaPizza() {
		dsl.clicarRadio(comidaPizzaId);
	}
	
	public void setComidaCarne() {
		dsl.clicarRadio(comidaCarneId);
	}
	
	public void setComidaFrango() {
		dsl.clicarRadio(comidaFrangoId);
	}
	
	public void setComidaVegetariano() {
		dsl.clicarRadio(comidaVegetarianaId);
	}

	public void setEscolaridade(String valor) {
		dsl.selecionarCombo(comboEscolaridadeId, valor);
	}

	public void setEsporte(String... valores) {
		for (String valor : valores) {
			dsl.selecionarComboByVisibleText(comboEsportesId, valor);
		}
	}

	public void setSugestoes(String valor) {
		dsl.escrever(sugestoesId, valor);
	}

	public void cadastrar() {
		dsl.clicar(btnCadastrarId);
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

	public String obterTextoAlert() {
		return dsl.obterTextoAlert();
	}

	public final String getNomeId() {
		return nomeId;
	}

	public final String getSobrenomeId() {
		return sobrenomeId;
	}

	public final String getSexoMasculinoId() {
		return sexoMasculinoId;
	}

	public final String getSexoFemininoId() {
		return sexoFemininoId;
	}

	public final String getComidaCarneId() {
		return comidaCarneId;
	}

	public final String getComidaFrangoId() {
		return comidaFrangoId;
	}

	public final String getComidaPizzaId() {
		return comidaPizzaId;
	}

	public final String getComidaVegetarianaId() {
		return comidaVegetarianaId;
	}

	public final String getComboEscolaridadeId() {
		return comboEscolaridadeId;
	}

	public final String getComboEsportesId() {
		return comboEsportesId;
	}

	public final String getSugestoesId() {
		return sugestoesId;
	}

	public final String getBtnCadastrarId() {
		return btnCadastrarId;
	}

	
	
}
