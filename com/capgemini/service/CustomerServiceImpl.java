package com.capgemini.service;

import com.capgemini.beans.AccountDetails;
import com.capgemini.beans.LoanDetails;
import com.capgemini.dao.Dao;
import com.capgemini.dao.DaoImpl;

public class CustomerServiceImpl implements CustomerService {
Dao dao;
	
	public CustomerServiceImpl() {
		dao= new DaoImpl();
	}

	@Override
	public boolean validateAccountId(String id) {
		String regexId = "^[0-9]{7}[A-Za-z]{4}$";
		return id.matches(regexId);
	}

	@Override
	public boolean validateAccountName(String name) {
		String regexName = "^[A-Z]{1}[a-z]{2,30}$";
		return name.matches(regexName);
	}

	@Override
	public int depositAmount(String accId, int amt) {
		// TODO Auto-generated method stub
		return dao.depositAmount(accId, amt);
	}

	@Override
	public int withdrawAmount(String accId, int amt) {
		// TODO Auto-generated method stub
		return dao.withdrawAmount(accId, amt);
	}

	@Override
	public AccountDetails showAccountDetails(String accountNo) {
		return dao.showAccountDetails(accountNo);
		
	}

	@Override
	public void createAccount(AccountDetails account) {
		dao.createAccount(account);
		
	}
	
	public int getLoan(long loanId,int lamt) {
		return dao.getLoan(loanId, lamt);
	}

	@Override
	public LoanDetails showLoanDetails(long loanId) {
		return dao.showLoanDetails(loanId);
		
	}

	@Override
	public int payLoan(long loanId, int lamt) {
		return dao.payLoan(loanId, lamt);
	}




}
