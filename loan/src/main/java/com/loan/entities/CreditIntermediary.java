package com.loan.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditIntermediary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String telephoneNumber;
    private String address;
    private String brokerName;
    private String brokerCommission;
    private String networkName;
    private String mortgageClubName;
    
    
	public CreditIntermediary() {
		super();
	}
	public CreditIntermediary(Long id, String companyName, String telephoneNumber, String address, String brokerName,
			String brokerCommission, String networkName, String mortgageClubName) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.telephoneNumber = telephoneNumber;
		this.address = address;
		this.brokerName = brokerName;
		this.brokerCommission = brokerCommission;
		this.networkName = networkName;
		this.mortgageClubName = mortgageClubName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
    
    // Constructors, getters, setters
    
    
    
    
    
    
    
}