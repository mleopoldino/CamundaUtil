package br.com.interfile.interflow.core.commons.robot;

public class RobotReturn {
	
	String status;
	
	String description;
	
	String date;
	
	String price;
	
	String error;
	
//	String errorInterno;
//	
//	String errorSearch;
	
	//CRM
	
	String name;
	String situation;
	
	//NF - Nota Fiscal
	
	String existingNF;
	String errorNF;
	
	//======================================================================
	
//	public String getErrorSearch() {
//		return errorSearch;
//	}
//
//	public void setErrorSearch(String errorSearch) {
//		this.errorSearch = errorSearch;
//	}
//	
//	public String getErrorInterno() {
//		return errorInterno;
//	}
//
//	public void setErrorInterno(String errorInterno) {
//		this.errorInterno = errorInterno;
//	}
	

	public String getExistingNF() {
		return existingNF;
	}

	public void setExistingNF(String existingNF) {
		this.existingNF = existingNF;
	}

	public String getErrorNF() {
		return errorNF;
	}

	public void setErrorNF(String errorNF) {
		this.errorNF = errorNF;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
