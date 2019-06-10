package br.com.interfile.interflow.core.commons.robot;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Bot_NF{

	/***
	 * Verifica a Validacao de uma NF
	 * @param cnpj CNPJ da nota
	 * @param numeroNota Numero da nota
	 * @param codigoVerificacao Codigo de Verificacao da nota
	 * @return Flag de NF valida ou nao
	 */
	static public boolean consultarNF(String cnpj, String numeroNota, String codigoVerificacao) {

		try {
			List<String> arguments = new ArrayList<String>();
			arguments.add("window-size=1980,960");
			arguments.add("--no-sandbox");
			arguments.add("--disable-dev-shm-usage");
			arguments.add("--headless");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments(arguments);
			
//	        chromeOptions.setHeadless(Boolean.valueOf(System.getProperty("webdriver.chrome.headless")));m
	        
	        WebDriver driver = new ChromeDriver(chromeOptions);
			
//			InterflowHealthReimbursementMarshPropertiesUtil util = new InterflowHealthReimbursementMarshPropertiesUtil();
//			System.setProperty("webdriver.chrome.driver", util.getChromeDriver());
//			WebDriver driver = new ChromeDriver();
			
	        //===================================================================
				
			// Acessando a url
			driver.get("https://nfe.prefeitura.sp.gov.br/publico/verificacao.aspx");
			//driver.manage().window().maximize();
			CommonMarshBot common = new CommonMarshBot(driver);

			//===================================================================
			
			RobotReturn robotReturn = common.validarNFSaoPaulo(cnpj, numeroNota, codigoVerificacao);
			
//			System.out.println("STATUS: " + robotReturn.getStatus());
//			System.out.println("DATE: " + robotReturn.getDate());
//			System.out.println("DESCRIPTION: " + robotReturn.getDescription());
//			System.out.println("ERROR: " + robotReturn.getError());
//			System.out.println("NAME: " + robotReturn.getName());
//			System.out.println("PRICE: " + robotReturn.getPrice());
//			System.out.println("SITUATION: " + robotReturn.getSituation());
//			System.out.println("EXISTINGNF: " + robotReturn.getExistingNF());
//			System.out.println("ERRORNF: " + robotReturn.getErrorNF());
//				
			driver.close();
			
			//===================================================================
			
			//Tratamento da Resposta do Robo
			if(robotReturn.getExistingNF().compareTo("Nota_Fiscal_Encontrada") == 0)
				return true;

		}catch (Exception e) {
			System.err.println("Erro no robo Consultar Nota Fiscal. CNPJ: " + cnpj + " - Numero da Nota: " + numeroNota + " - Codigo de Verificacao: " + codigoVerificacao + " " + e);
		}	
			
		return false;
	}
}
