package com.capgemini.beans;

public class AccountDetails {
private String accountId;
private String accountName;
private Address address;
private int depositAmount;
public String getDetails() {
	return getAccountName()+" "+getAccountId()+" "+address.getCity()+" "+address.getState()+" "+getDepositAmount();
}

public void showDetails() {
	System.out.println("Account Name :"+getAccountName());
	System.out.println("Account Id : "+getAccountId());
	System.out.println("Address : "+getAddress().getCity()+" "+getAddress().getState());
	System.out.println("Deposit Amount is :"+getDepositAmount());
}




@Override
public String toString() {
	return "AccountDetails [accountId=" + accountId + ", accountName=" + accountName + ", city=" + address.getCity()+ ", state= "+address.getState()+", address=" + address + ", depositAmount=" + depositAmount + "]";
}

public AccountDetails() {
	super();
	
}

public AccountDetails(String accountId, String accountName, Address address, int depositAmount) {
	super();
	this.accountId = accountId;
	this.accountName = accountName;
	this.address = address;
	this.depositAmount = depositAmount;
}

public String getAccountId() {
	return accountId;
}
public void setAccountId(String accountId) {
	this.accountId = accountId;
}
public String getAccountName() {
	return accountName;
}
public void setAccountName(String accountName) {
	this.accountName = accountName;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public int getDepositAmount() {
	return depositAmount;
}
public void setDepositAmount(int depositAmount) {
	this.depositAmount = depositAmount;
}
    



}
