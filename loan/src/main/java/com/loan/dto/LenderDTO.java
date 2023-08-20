package com.loan.dto;

public class LenderDTO {
    private String name;
    private String telephoneNumber;
    private String address;
    
	public LenderDTO(String name, String telephoneNumber, String address) {
		super();
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.address = address;
	}
	public LenderDTO() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
    
    
    
}