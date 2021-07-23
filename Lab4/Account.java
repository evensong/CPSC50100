import java.util.Scanner;

public class Account {
	static int numAccounts = 0;
	
	Account(){
		numAccounts++;
	}
	
	static int getNumAccounts() {
		return numAccounts;
	}
	
	public static void main(String[] args) {
		int accountsToMake = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many accounts would you like to make? Enter an integer value: ");
		accountsToMake = scan.nextInt();
		
		Account[] accounts = new Account[accountsToMake]; 
		
		for (int index = 0; index < accountsToMake; index++) { //create array of account objects
			accounts[index] = new Account();
		}
		
		System.out.println(Account.getNumAccounts() + " account(s) created."); //check that numAccounts properly updated
		
		scan.close();
	}

}
