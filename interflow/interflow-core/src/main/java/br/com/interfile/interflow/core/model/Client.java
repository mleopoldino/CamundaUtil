package br.com.interfile.interflow.core.model;

public class Client {

	private Long id;
	private String name;
	private String tennantId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTennantId() {
		return tennantId;
	}

	public void setTennantId(String tennantId) {
		this.tennantId = tennantId;
	}

}
