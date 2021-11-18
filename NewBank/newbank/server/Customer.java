package newbank.server;

import java.util.ArrayList;

public class Customer {
	
	private ArrayList<Account> accounts;
	private double balance;
	
	public Customer() {
		accounts = new ArrayList<>();
	}
	
	public String accountsToString() {
		String s = "";
		for(Account a : accounts) {
			s += a.toString();
		}
		return s;
	}

	public void addAccount(Account account) {
		accounts.add(account);		
	}
	
	//function to get accounts array
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	// function to move money between a customer's accounts
	public boolean moveMoney(Account from, Account to, double amount) {
		if (from.getBalance() >= amount){
			from.removeMoney(amount);
			to.addMoney(amount);
			return true;
		}
		else{
			return false;
		}
	}
	
	/*function to make payment to some person/company
	 * possibly to add code to pay into specific accounts in the future 
	 */
	public void makePayment(double amount, Account openingBalance) {
		balance = openingBalance.getBalance();
		balance -= amount; 		
	}
        
        /*
          Function to withdraw money from a specific account
        */
        public String withdrawMoney(String account, String amount){
                double withdrawal = Double.parseDouble(amount);
                String infoMessage = "";
                
                // iterate through all the customer's accounts
                // if account found AND funds avaialble then withdraw amount
                for(Account a : accounts) {
                    if (account.equalsIgnoreCase(a.getCustomer())){
                      if(a.removeMoney(withdrawal)){
                        infoMessage = "Successfully withdrawn " + amount + " from account " + a.getCustomer();
                      }
                      else{
                        infoMessage = "Insufficient funds. Please check account balance.";
                      }
                    }
                    else {
                      infoMessage = "Account not found.";
                    }
		}
                
                return infoMessage;
        }
}
