package br.com.test.database.entity;

public class CustomerAccount {

	private Integer id;
	private String cpfCnpj;
	private String name; 
	private boolean isActive;
	private Float totalValue;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public Float getTotalValue() {
		return totalValue;
	}
	
	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}
	
}
