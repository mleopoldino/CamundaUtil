package br.com.interfile.interflow.core.commons.util;

import java.io.File;

public class InterflowUtil {
	  
		/**
	    * Verifica o Separador de Arquivos 
	    * @return O caracter separador (Windows: '\\' | Linux: '/')
	    */
	    static public char getSeparadorArquivos(){
	        return File.separatorChar;
	    }   
	   
	    /***
	     * Verifica o Endereco da Pasta de Configuracao da Maquina (Windows ou Linux)
	     * @return O endereco da pasta (ERRO: NULL)
	     */
	    static public String getConfigPath(){
	    	
	    	String config_path = System.getProperty("configPath") + getSeparadorArquivos();	    	
//	    	System.out.println("CONFIG PATH: " + config_path);
	    	
	    	return config_path;
	    	
//	    	String configDir = "config";
//	    	
//	    	if(InterflowUtil.isWindows()) return "C:\\" + configDir + "\\";
//	    	else return "/home/" +  configDir + "/";
	    }
	    
//	    /** Verifica se o SO eh Windows ou Derivados
//		    * @return Flag de verificacao se eh windows ou nao
//		    */
//		   static public boolean isWindows(){
//		    
//		       if(System.getProperty("os.name").toLowerCase().contains("windows"))
//		           return true;
//		           
//		       return false;
//		   }
//		     
//	    
//		 /***
//	    * Verifica as Raizes dos Drivers de Disco (Filesystem Roots)
//	    * @return Lista de Files dos drivers
//	    */
//	   static public File[] getRootDrivers(){
//	       
//	       return File.listRoots();
//	   }
//	   
//	   /***
//	    * Verifica o Drive Raiz da Maquina
//	    * @return O drive raiz (ERRO: NULL)
//	    */
//	   static public String getRootDriver(){
//	       
//		   try{
//				return getRootDrivers()[0].getCanonicalPath();
//			}catch (Exception e) {
//				System.err.println("Erro ao verificar o Drive Root.");
//				System.err.println(e);
//			}
//		   
//		   return null;
//	   }
	 
}
