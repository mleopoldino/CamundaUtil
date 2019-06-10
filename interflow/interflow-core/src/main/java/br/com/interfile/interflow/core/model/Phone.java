package br.com.interfile.interflow.core.model;

import java.io.Serializable;

public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private PhoneType type;
	private String number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
