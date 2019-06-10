package br.com.interfile.interflow.core.model;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String vatId;
	private String username;

	private List<Phone> phones;
	private List<String> tenantIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVatId() {
		return vatId;
	}

	public void setVatId(String vatId) {
		this.vatId = vatId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<String> getTenantIds() {
		return tenantIds;
	}

	public void setTenantIds(List<String> tenantIds) {
		this.tenantIds = tenantIds;
	}

}
