package br.com.interfile.interflow.core.commons.robot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {

	WebDriver driver;

	public Util(WebDriver driver) {
		this.driver = driver;
	}
	
	//================================================================================

	static public void sleep(int miliseg) {
	
		try{
			Thread.sleep(miliseg);
		}catch (InterruptedException e){					
			e.printStackTrace();
		}
	}
	
	static public String convertDoubleToStringFormatted(Double value){
		
		return String.format("%1$,.2f", value);
	}
	
	static public String verifyAndConvertMonetaryValue(String value){
		
		if((value != null) && (value.length() > 3)){ // > 3 devido ao separador e as 2 casas decimais 
	
			Character separador = value.charAt(value.length() - 3);
			
			if((separador != null) && (separador.equals('.') || separador.equals(','))) {
				
				 if(separador.equals('.')){
					 
					 value = value.replace('.', '_');
					 value = value.replaceAll(",", ".");
					 value = value.replace('_', ',');
				 }	
			}
		}
		
		return value;
	}
	
	//================================================================================
	
	public void executeJavascript(String javascript) {
		
		if(driver instanceof JavascriptExecutor)
			((JavascriptExecutor)driver).executeScript(javascript);
	}
	
	public String getXPathWebElement(WebElement element) {
	
        if(element != null){
        	
            String text = element.toString();
            	System.out.println("XPATH: " + text);            
            text = text.substring(text.indexOf("xpath: ")+7, text.length()-1);
            	System.out.println("XPATH SUBSTRING: " + text);
            return text;
        }
        
        return null;
	}
	
	public String getAttributeWebElement(WebElement element, String attribute) {
		
		if(element != null)
			return element.getAttribute(attribute);
		
		return null;
	}
	
	public String getValueWebElement(WebElement element) {
		
		return getAttributeWebElement(element, "value");
	}
	
	public String getHrefWebElement(WebElement element) {
		
		return getAttributeWebElement(element, "href");
	}
	
	public WebElement buscarElementoByIDWithoutException(String id, int intervalo, int timeout) {
		
		try {
			for(int i = 0; i < timeout; i++){
				
				sleep(intervalo);
				
				WebElement element = driver.findElement(By.id(id));
				
				if(element == null)
					continue;
	
				return element;
			}
		}catch (Exception e){}
			
		return null;
	}
	
	public WebElement buscarElementoByID(String id, int intervalo, int timeout) {
		
		for(int i = 0; i < timeout; i++){
			
			sleep(intervalo);
			
			WebElement element = driver.findElement(By.id(id));
			
			if(element == null)
				continue;

			return element;
		}
		
		return null;
	}
	
	public WebElement buscarElemento(String xpath, int intervalo, int timeout) {
		
		for(int i = 0; i < timeout; i++){
			
			sleep(intervalo);
			
			WebElement element = driver.findElement(By.xpath(xpath));
			
			if(element == null)
				continue;

			return element;
		}
		
		return null;
	}

	//________Caso seja necessario encontrar mais de um elemento na tela___________________
	
	public List<WebElement> buscarElementos(String xpath, int intervalo, int timeout) {
		
		for(int i = 0; i < timeout; i++){
			
			sleep(intervalo);
			
			List<WebElement> elements = driver.findElements(By.xpath(xpath));
			
			if(elements == null){
				continue;
			}

			return elements;
		}
		
		return null;
	}
	
	//================================================================================
	
	
	//______________Robo Consulta CRM__________________________________________________
    
    public WebElement buscarCampoCRM(int intervalo, int timeout) {
		
		return this.buscarElemento("//input[@id=\"medicosCRM\"]", intervalo, timeout);
	}
    
    public WebElement buscarBotaoCRM(int intervalo, int timeout) {
		
		return this.buscarElemento("//input[@id=\"btnBuscar\"]", intervalo, timeout);
	}
	
   public WebElement buscarIDCaptcha(int intervalo, int timeout) {
		
		return this.buscarElemento("//body", intervalo, timeout);
	}
   
   public WebElement buscarReCaptcha(int intervalo, int timeout) {
		
		return this.buscarElemento("//textarea[@id=\"g-recaptcha-response\"]", intervalo, timeout);
	}
   
   public WebElement buscarNomeMedico(int intervalo, int timeout) {
		
		return this.buscarElemento("//table[@id='tableMedicos']/tbody/tr[2]/td[1]/span", intervalo, timeout);
	}
   
   public WebElement buscarSituacaoCRM(int intervalo, int timeout) {
		
		return this.buscarElemento("//table[@id='tableMedicos']/tbody/tr[2]/td[2]/span", intervalo, timeout);
	}
  
   
   //------------------------- Validar NF -----------------------------------------------
   
   public WebElement buscarCampoCNPJNF(int intervalo, int timeout) {
		
		return this.buscarElemento("//input[@id=\"ctl00_body_tbCPFCNPJ\"]", intervalo, timeout);
	}
   
   public WebElement buscarCampoNumeroNotaNF(int intervalo, int timeout) {
		
		return this.buscarElemento("//input[@id=\"ctl00_body_tbNota\"]", intervalo, timeout);
	}
   
   public WebElement buscarCampoCodigoVerificacaoNF(int intervalo, int timeout) {
		
		return this.buscarElemento("//input[@id=\"ctl00_body_tbVerificacao\"]", intervalo, timeout);
	}
   
   public WebElement buscarBotaoAutenticidadeNF(int intervalo, int timeout) {
		
		return this.buscarElemento("//input[@id=\"ctl00_body_btVerificar\"]", intervalo, timeout);
	}
   
   public WebElement buscarExistingNotaFiscal(int intervalo, int timeout) {
		
		return this.buscarElemento("//input[@id=\"ctl00_cphBase_btVoltar\"]", intervalo, timeout);
	}
   
   public WebElement buscarExistingErroNotaFiscal(int intervalo, int timeout) {
		
		return this.buscarElemento("//span[@id=\"ctl00_body_cvVerificacao\"]", intervalo, timeout);
	}
 	 
	   //____________________Robo SulAmerica Odonto__________________________________________
	   
//	   public WebElement buscarCodigoSulOdonto(int intervalo, int timeout) {
//			
//			return this.buscarElemento("//input[@id=\"code\"]", intervalo, timeout);
//		}
//	   
//	   public WebElement buscarIdentificacaoSulOdonto(int intervalo, int timeout) {
//			
//			return this.buscarElemento("//input[@id=\"user\"]", intervalo, timeout);
//		}
//	   
//	   public WebElement buscarSenhaSulOdonto(int intervalo, int timeout) {
//			
//			return this.buscarElemento("//input[@id=\"senha\"]", intervalo, timeout);
//		}
//	   
//	   public WebElement buscarBotaoEntrarSulOdonto(int intervalo, int timeout) {
//			
//			return this.buscarElemento("//a[@onclick=\"validateFormLogin(event);\"]", intervalo, timeout);
//		}
//	   
//	   public WebElement buscarMenuOdontoSulOdonto(int intervalo, int timeout) {
//			
//			return this.buscarElemento("//a[@href=\"../../data/pages/8A6189BE4335158B0143351D372B189F.htm\"]", intervalo, timeout);
//		}
//	   
//	   public WebElement buscarLinkClique(int intervalo, int timeout) {
//			
//			return this.buscarElemento("//div//div//a[@href=\"/main.jsp?lumChannelId=8A6213C157107E82015710D6C14C12A8\"]", intervalo, timeout);
//		}
//	   
//	   public WebElement buscarMenuCadastroOnline(int intervalo, int timeout) {
//			
//			return this.buscarElemento("//table[@id='ctl00_WebMenu_I4_CT']/tbody/tr/td", intervalo, timeout);
//		}
//	   
//	   public WebElement buscarMenuAcompanhamentoReembolsoOdontoSul(int intervalo, int timeout) {
//			
//			return this.buscarElemento("//table[@id='ctl00_WebMenu_I20_CT']/tbody/tr/td", intervalo, timeout);
//		}
//	   
//	   public WebElement buscarConsultaSRSulOdonto(String sRSulOdonto, int intervalo, int timeout) {
//			
//			return this.buscarElemento("//table[@id='ctl00_BodyPlace_gridReemb']/tbody/tr/td/a[contains(text(), '" + sRSulOdonto + "')]", intervalo, timeout);
//		}
}
