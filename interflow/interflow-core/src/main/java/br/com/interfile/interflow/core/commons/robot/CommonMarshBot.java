package br.com.interfile.interflow.core.commons.robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMarshBot {

	WebDriver driver;
	Util util;

	public CommonMarshBot(WebDriver driver) {
		this.driver = driver;
		this.util = new Util(driver);
	}

	// ____________________Robo Consulta CRM__________________________

	public String qubraCaptcha() {

		String apiKey = "4acfde9455828492ffe4526abb2dfdbc";
		String googleKey = "6LeyFxsUAAAAAJF6u5CHRPN4F_xPV3QyOokBjqLY";
		String pageUrl = "https://portal.cfm.org.br/index.php?option=com_medicos";
		String responseToken = "";

		try {
			TwoCaptchaService service = new TwoCaptchaService(apiKey, googleKey, pageUrl);
			responseToken = service.solveCaptcha();
			System.out.println("The response token is: " + responseToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseToken;
	}

	public RobotReturn consultarCRM(String responseToken, String UF, String crm) {

		RobotReturn retorno = new RobotReturn();

		Select uF = new Select(driver.findElement(By.xpath("//select[@id='medicosUF']")));
		uF.selectByValue(UF);

		WebElement campoCRM = util.buscarCampoCRM(100, 3);
		campoCRM.sendKeys(crm);

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("document.getElementById('g-recaptcha-response').style.display='block'");
		jsExecutor.executeScript("document.getElementById('btnBuscar').disabled = false;");

		WebElement recaptchaResponse = util.buscarReCaptcha(100, 3);
		recaptchaResponse.sendKeys(responseToken);

		WebElement botaoBuscarCRM = util.buscarBotaoCRM(100, 3);
		botaoBuscarCRM.click();

		WebElement statusNomeMedico = util.buscarNomeMedico(100, 3);

		WebElement statusSituacaoCRM = util.buscarSituacaoCRM(100, 3);

		String valorstatusNomeMedico = statusNomeMedico.getText();
		String valorstatusSituacaoCRM = statusSituacaoCRM.getText();

		if ((valorstatusNomeMedico != null) && (valorstatusSituacaoCRM != null)) {

			retorno.setName(valorstatusNomeMedico);
			retorno.setSituation(valorstatusSituacaoCRM);

		} else {

			System.out.println("Erro: Consulta efetuada nao existente na base do CFM, favor disponibilizar um novo CRM");
		}

		return retorno;
	}
	
	// --------------------------------- Validar NF Sao Paulo
	// -------------------------------------------

	public RobotReturn validarNFSaoPaulo(String cnpj, String numeroNota, String codigoVerificacao) {

		RobotReturn retorno = new RobotReturn();

		WebElement campoCNPJ = util.buscarCampoCNPJNF(100, 3);
		campoCNPJ.sendKeys(cnpj);

		WebElement campoNumeroNota = util.buscarCampoNumeroNotaNF(100, 3);
		campoNumeroNota.sendKeys(numeroNota);

		WebElement campoCodigoVerificacao = util.buscarCampoCodigoVerificacaoNF(100, 3);
		campoCodigoVerificacao.sendKeys(codigoVerificacao);

		WebElement botaoAutenticidade = util.buscarBotaoAutenticidadeNF(100, 3);
		botaoAutenticidade.click();
		try {
			if ((driver.findElement(By.xpath("//input[@id=\"ctl00_cphBase_btVoltar\"]")).getSize() != null)) {

				retorno.setExistingNF("Nota_Fiscal_Encontrada");

			}
		} catch (NoSuchElementException e) {
			if ((driver.findElement(By.xpath("//span[@id=\"ctl00_body_cvVerificacao\"]")).getSize() != null)) {

				retorno.setErrorNF("Nota_Fiscal_Nao_Encontrada");
			}
		}
		return retorno;
	}

	
	// -------------------- SulAmerica Odontologico - FORA DO ESCOPO
	// ------------------------------------------------------------

	// Declarando variaveis de Login
//	String codigoSulOdonto = "31781";
//	String identificacaoSulOdonto = "31781";
//	String senhaSulOdonto = "mudar@123";
//
//	// Declarando variaveis de busca
//	String sRSulOdonto = "5140115789";
//	
//	 public String qubraCaptchaSulAmerica() {
//	
//		 String apiKey = "4acfde9455828492ffe4526abb2dfdbc";
//		 String googleKey = "6LdR1EYUAAAAAPZ9WKzOkN1o5ciaXd2O44k_NpQ3";
//		 String pageUrl = "https://portal.sulamericaseguros.com.br/main.jsp?lumChannelId=8A6213C157107E82015710D6C14C12A8";
//		 String responseToken = "";
//		
//		 try {
//			 TwoCaptchaService service = new TwoCaptchaService(apiKey, googleKey,
//			 pageUrl);
//			 responseToken = service.solveCaptcha();
//			 System.out.println("The response token is: " + responseToken);
//		 } catch (Exception e) {
//			 e.printStackTrace();
//		 }
//	
//		 return responseToken;
//	}
//		
//	public RobotReturn consultaPagamentoSulAmericaOdonto(String responseToken,
//		 String codigoSulOdonto,
//		 String identificacaoSulOdonto, String senhaSulOdonto, String sRSulOdonto) {
//		
//		 RobotReturn retorno = new RobotReturn();
//		
//		 WebElement menuParaEmpresa = util.buscarMenuParaEmpresa(100, 3);
//		 menuParaEmpresa.click();
//		
//		 WebElement menuOdonto = util.buscarMenuOdontoSulOdonto(100, 3);
//		 menuOdonto.click();
//		
//		 WebElement cliqueSaudeOnlineSul = util.buscarLinkClique(100, 3);
//		 String link = cliqueSaudeOnlineSul.getAttribute("href");
//		
//		 driver.get(link);
//		
//		 WebElement campoCodigoSulOdonto = util.buscarCodigoSulOdonto(1000, 3);
//		 campoCodigoSulOdonto.sendKeys(codigoSulOdonto);
//		
//		 WebElement campoIdentificacaoSulOdonto =
//		 util.buscarIdentificacaoSulOdonto(1000, 3);
//		 campoIdentificacaoSulOdonto.sendKeys(identificacaoSulOdonto);
//		
//		 WebElement campoSenhaSulOdonto = util.buscarSenhaSulOdonto(1000, 3);
//		 campoSenhaSulOdonto.sendKeys(senhaSulOdonto);
//		
//		 // Declarando variaveis para if de login
//		 String valorcampoCodigoSulOdonto =
//		 campoCodigoSulOdonto.getAttribute("value");
//		 String valorcampoIdentificacaoSulOdonto =
//		 campoIdentificacaoSulOdonto.getAttribute("value");
//		 String valorcampoSenhaSulOdonto = campoSenhaSulOdonto.getAttribute("value");
//		
//		 if ((valorcampoCodigoSulOdonto != null) &&
//		 (valorcampoCodigoSulOdonto.length() > 0)
//		 && (valorcampoIdentificacaoSulOdonto != null) &&
//		 (valorcampoIdentificacaoSulOdonto.length() > 0)
//		 && (valorcampoSenhaSulOdonto != null) && (valorcampoSenhaSulOdonto.length() >
//		 0)) {
//		
//		 // Captcha deve passar aqui
//		
//		 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		 jsExecutor.executeScript("document.getElementById('g-recaptcha-response').style.display='block'");
//		 jsExecutor.executeScript("document.getElementByclass('btn btn-sm bg-orange text-white').disabled = true;");
//		
//		 WebElement recaptchaResponse = util.buscarReCaptcha(100, 3);
//		 recaptchaResponse.sendKeys(responseToken);
//		
//		 WebElement botaoEnviarSulOdonto = util.buscarBotaoEntrarSulOdonto(1000, 3);
//		 botaoEnviarSulOdonto.click();
//		
//		 driver.get("http://wsodonto.sulamerica.com.br/SaeNet/saemenu.aspx");
//		
//		 // instanciando a variavel do mouse hover
//		 Actions mouse = new Actions(driver);
//		
//		 WebElement menuCadastroOnline = util.buscarMenuCadastroOnline(1000, 3);
//		 mouse.moveToElement(menuCadastroOnline);
//		 mouse.build().perform();
//		
//		 WebElement menuAcompanhamentoReembolsoOdontoSul =
//		 util.buscarMenuAcompanhamentoReembolsoOdontoSul(1000, 3);
//		 mouse.moveToElement(menuAcompanhamentoReembolsoOdontoSul);
//		 mouse.click().build().perform();
//		
//		 WebElement consultaSRSulOdonto = util.buscarConsultaSRSulOdonto(sRSulOdonto,
//		 100, 3);
//		 consultaSRSulOdonto.click();
//		
//		 }else{
//		
//			 retorno.setError("SENHA_INVALIDA");
//			 return retorno;
//		 }
//		
//		 return retorno;
//	 }
}
