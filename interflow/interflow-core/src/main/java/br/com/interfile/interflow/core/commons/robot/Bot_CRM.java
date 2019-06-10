package br.com.interfile.interflow.core.commons.robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Bot_CRM{

	/***
	 * Verifica a Validacao de um CRM
	 * @param uf Uf do CRM a ser consultado
	 * @param crm CRM a ser consultado
	 * @return Flag de CRM valido (Regular) ou nao
	 */
	static public boolean consultarCRM(String uf, String crm) {

		try {
			ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("window-size=1980,960");
//	        chromeOptions.setHeadless(Boolean.valueOf(System.getProperty("webdriver.chrome.headless")));
	        chromeOptions.addArguments("--no-sandbox");
	        chromeOptions.addArguments("--disable-dev-shm-usage");
	        WebDriver driver = new ChromeDriver(chromeOptions);
			
	        //===================================================================
	        	
			// Acessando a url
	//		driver.get("https://portal.cfm.org.br/index.php?option=com_medicos");
	        CommonMarshBot common = new CommonMarshBot(driver);
			
			//===================================================================
			
			String responseToken = common.qubraCaptcha();
			
			driver.get("https://portal.cfm.org.br/index.php?option=com_medicos");
			
			RobotReturn robotReturn = common.consultarCRM(responseToken, uf, crm);
			
//			System.out.println("STATUS: " + robotReturn.getStatus());
//			System.out.println("DATE: " + robotReturn.getDate());
//			System.out.println("DESCRIPTION: " + robotReturn.getDescription());
//			System.out.println("ERROR: " + robotReturn.getError());
//			System.out.println("NAME: " + robotReturn.getName());
//			System.out.println("PRICE: " + robotReturn.getPrice());
//			System.out.println("SITUATION: " + robotReturn.getSituation());
//			System.out.println("EXISTINGNF: " + robotReturn.getExistingNF());
//			System.out.println("ERRORNF: " + robotReturn.getErrorNF());
				
			driver.close();
			
			//===================================================================
			
			//Tratamento da Resposta do Robo
			if(robotReturn.getSituation().compareTo("Regular") == 0)
				return true;

		}catch (Exception e) {
			System.err.println("Erro no robo Consultar CRM. " + crm + " - UF: " + uf + " " + e);
		}	
			
		return false;
	}
}
