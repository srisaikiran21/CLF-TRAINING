package com.capgemini.bankapplication;

import java.util.Scanner;

import com.capgemini.beans.AccountDetails;
import com.capgemini.beans.Address;
import com.capgemini.beans.LoanDetails;
import com.capgemini.beans.TransactionDetails;
import com.capgemini.service.CustomerService;
import com.capgemini.service.CustomerServiceImpl;

public class Application {
public static void main(String[] args) {
		
		TransactionDetails account =null;
		
		CustomerService service = null;
		
		service = new CustomerServiceImpl();
	
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("Choose any one");
			System.out.println("Select 1 to Create an account");
			System.out.println("Select 2 for Deposit");
			System.out.println("Select 3 for Withdraw");
			System.out.println("Select 4 for Show Account Details");
			System.out.println("Select 5 for Get Loan");
			System.out.println("Select 6 for Pay Loan");
			System.out.println("Select 7 for Show Loan Details");
			System.out.println("Select 8 Exit");
			switch(scan.nextInt()) {
			case 1 :
					account = new TransactionDetails();
					while(true) {
					System.out.println("Enter account Id");
					String accId = scan.next();
					if(service.validateAccountId(accId)) {	
						account.setAccountId(accId);
						break;
						}else {
							System.out.println("Entered account number is not in valid format");
							return;
						}
					}		//accountID
					
					while(true) {
						System.out.println("Enter user name");
						String uname = scan.next();
						if(service.validateAccountName(uname)) {
							account.setAccountName(uname);
							break;
						}else {
							System.out.println("Entered Name is not in valid format");
							return;	
						}
					}		//accountName
					System.out.println("Enter address: ");
					System.out.println("Enter City ");
					String city = scan.next();
					System.out.println("Enter State ");
					String state = scan.next();
					Address address = new Address(city,state);
					account.setAddress(address);
					
					System.out.println("Enter deposit amount");
					account.setDepositAmount(scan.nextInt());
					
					System.out.println(" Applying Loans...");
					System.out.println("1 for Yes \n 2 for No :");
					int ch = scan.nextInt();
					if(ch==1) {
						System.out.println("Enter loanId");
						account.setLoanId(scan.nextLong());
						
						System.out.println("Enter loan Type \n Home\t Car \t  Education");
						System.out.println("Loan Type must be any of three");
						account.setLoanType(scan.next());
						
						System.out.println("Enter loan amount");
						account.setLoanAmount(scan.nextInt());
						
						//System.out.println("");
						
					}
					System.out.println("Account is created");
					service.createAccount(account);break;
					
			case 2:
					System.out.println("Enter accountId :");
					String accId = scan.next();
					System.out.println("Enter amount :");
					int amt = scan.nextInt();
					int bal=service.depositAmount(accId, amt);
					System.out.println("New balance :"+bal);
					break;
					
			case 3:
					System.out.println("Enter accountId :");
					String accIdw = scan.next();
					System.out.println("Enter amount :");
					int amtw = scan.nextInt();
					int balw=service.withdrawAmount(accIdw, amtw);
					System.out.println("New balance :"+balw);
					break;
					
			case 4:
					System.out.println("Enter AccountId :");
					String acnt = scan.next();
					AccountDetails act = service.showAccountDetails(acnt);
					if(act!=null) {
						System.out.println(act);
						break;
					}else {
						System.out.println("Not found");
						break;
					}
					
			case 5:
					System.out.println("Enter amount of loan: ");
					int lamt = scan.nextInt();
					System.out.println("Enter loanId : ");
					long lid = scan.nextLong();
					int lbal = service.getLoan(lid, lamt);
					System.out.println(lbal+" loan amount got");
					break;
			
			case 6:
					System.out.println("Enter amount : ");
					int plamt = scan.nextInt();
					System.out.println("Enter loanId : ");
					long plid = scan.nextLong();
					int plbal = service.payLoan(plid, plamt);
					System.out.println("paid loan amount "+plbal);
					break;
					
			case 7:
					System.out.println("Enter loanId : ");
					long lId = scan.nextLong();
					LoanDetails loan = service.showLoanDetails(lId);
					if(loan!=null)
						System.out.println("Loan Id ="+loan.getLoanId()+" Loan type = "+loan.getLoanType()+" Loan Amount = "+loan.getLoanAmount());
					else
						System.out.println("loanId not matched");
					
					break;
					
			case 8:
					System.out.println("Thank you");break;
			}
		}

		

	}

}
