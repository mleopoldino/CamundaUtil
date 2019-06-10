package br.com.interfile.interflow.core.commons;

public class TaskDeliveryNotifyVariable {

	private String label;
	private String value;

	public TaskDeliveryNotifyVariable(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
