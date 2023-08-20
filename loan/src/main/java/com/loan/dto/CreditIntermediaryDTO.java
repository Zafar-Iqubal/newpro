package com.loan.dto;

public class CreditIntermediaryDTO {
    private String companyName;
    private String telephoneNumber;
    private String address;
    private String brokerName;
    private String brokerCommission;
    private String networkName;
    private String mortgageClubName;
    
    
	public CreditIntermediaryDTO() {
		super();
	}
	
	public CreditIntermediaryDTO(String companyName, String telephoneNumber, String address, String brokerName,
			String brokerCommission, String networkName, String mortgageClubName) {
		super();
		this.companyName = companyName;
		this.telephoneNumber = telephoneNumber;
		this.address = address;
		this.brokerName = brokerName;
		this.brokerCommission = brokerCommission;
		this.networkName = networkName;
		this.mortgageClubName = mortgageClubName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	public String getBrokerName() {
		return brokerName;
	}
	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}
	public String getBrokerCommission() {
		return brokerCommission;
	}
	public void setBrokerCommission(String brokerCommission) {
		this.brokerCommission = brokerCommission;
	}
	public String getNetworkName() {
		return networkName;
	}
	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}
	public String getMortgageClubName() {
		return mortgageClubName;
	}
	public void setMortgageClubName(String mortgageClubName) {
		this.mortgageClubName = mortgageClubName;
	}
    
    
}