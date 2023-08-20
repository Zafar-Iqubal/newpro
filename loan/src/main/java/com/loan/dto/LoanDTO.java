package com.loan.dto;



import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {
	
    private String consumerName;
    private Date currentDate;
    private Date validityDate;
    private String reference;
    
	public LoanDTO(String consumerName, Date currentDate, Date validityDate, String reference) {
		super();
		this.consumerName = consumerName;
		this.currentDate = currentDate;
		this.validityDate = validityDate;
		this.reference = reference;
	}
	public LoanDTO() {
		super();
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public Date getValidityDate() {
		return validityDate;
	}
	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
    
}