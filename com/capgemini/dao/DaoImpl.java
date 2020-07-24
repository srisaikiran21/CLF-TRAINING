package com.capgemini.dao;

import com.capgemini.beans.AccountDetails;
import com.capgemini.beans.LoanDetails;
import com.capgemini.beans.TransactionDetails;

public class DaoImpl implements Dao{
	TransactionDetails[] accounts = new TransactionDetails[10];
	private static int i = 0;
	int amount = 0;
	int loanBal = 0;

	@Override
	public int depositAmount(String accId, int amt) {
		
		for(AccountDetails acc : accounts) {
			if(acc.getAccountId().equals(accId)) {
				amount = acc.getDepositAmount()+amt;
				acc.setDepositAmount(acc.getDepositAmount()+amt);
				System.out.println("Deposit succesful");
				break;
			}
		}
		return amount;
	}

	@Override
	public int withdrawAmount(String accId, int amt) {
		// TODO Auto-generated method stub
		for(AccountDetails ac : accounts) {
			if(ac.getAccountId().equals(accId)) {
				amount = ac.getDepositAmount()-amt;
				ac.setDepositAmount(ac.getDepositAmount()+amt);
				System.out.println("Withdraw succesful");
				break;
			}
		}
		return amount;
	}

	@Override
	public AccountDetails showAccountDetails(String accountNo) {
		for(AccountDetails acc : accounts) {
			if(acc.getAccountId().equals(accountNo)) {
				return acc;
			}
		}
		return null;
	}

	@Override
	public void createAccount(AccountDetails account) {
		if(i<9)
			accounts[i++]=(TransactionDetails) account;
		else
			System.out.println("Array size full");
		
	}

	@Override
	public int getLoan(long loanId, int lamt) {
		// TODO Auto-generated method stub
		
		for(LoanDetails l : accounts) {
			if(l.getLoanId()==loanId) {
				loanBal = l.getLoanAmount()+lamt;
				l.setLoanAmount(l.getLoanAmount()+lamt);
				l.setLoanAmount(loanBal);
				break;
			}
		}
		return loanBal;
	}

	@Override
	public LoanDetails showLoanDetails(long loanId) {
		for(LoanDetails l : accounts) {
			if(l.getLoanId()==loanId) {
				return l;
			}
		}return null;
	}

	@Override
	public int payLoan(long loanId, int lamt) {
		int loanBal = 0;
		for(LoanDetails l : accounts) {
			if(l.getLoanId()==loanId) {
				loanBal = l.getLoanAmount()-lamt;
				l.setLoanAmount(l.getLoanAmount()-lamt);
				l.setLoanAmount(loanBal);
				break;
			}
		}
		return loanBal;
		
	}


}
