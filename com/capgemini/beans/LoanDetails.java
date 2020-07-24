package com.capgemini.beans;

public class LoanDetails extends AccountDetails{
private long loanId;
private String  loanType;
private int loanAmount;


public void showLoanDetails() {
	System.out.println("Loan Id = "+getLoanId());
	System.out.println("Loan amount = "+getLoanAmount());
	System.out.println("Loan Type = "+getLoanType());
}


public long getLoanId() {
	return loanId;
}
public void setLoanId(long loanId) {
	this.loanId = loanId;
}
public String getLoanType() {
	return loanType;
}
public void setLoanType(String loanType) {
	this.loanType = loanType;
}
public int getLoanAmount() {
	return loanAmount;
}
public void setLoanAmount(int loanAmount) {
	this.loanAmount = loanAmount;
}


}
