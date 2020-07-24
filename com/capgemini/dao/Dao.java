package com.capgemini.dao;

import com.capgemini.beans.AccountDetails;
import com.capgemini.beans.LoanDetails;

public interface Dao {
	public int depositAmount(String accId,int amt);
	public int withdrawAmount(String accId,int amt);
	public AccountDetails showAccountDetails(String accountNo);
	public void createAccount(AccountDetails account);
	
	public int getLoan(long loanId,int lamt);
	public int payLoan(long loanId,int lamt);
	public LoanDetails showLoanDetails(long loanId);
}

