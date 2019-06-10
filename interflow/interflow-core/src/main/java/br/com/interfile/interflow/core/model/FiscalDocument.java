package br.com.interfile.interflow.core.model;

import java.io.Serializable;

public class FiscalDocument implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long number;
	private String date;
	private Double value;
	private String paymentDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String string) {
		this.paymentDate = string;
	}

}
