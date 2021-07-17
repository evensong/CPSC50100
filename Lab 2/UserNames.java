import java.util.Scanner;
import java.util.Random;
public class UserNames {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random numGen = new Random();
		
		String firstName = " "; //Variables to be formatted and output as a username
		String lastName = " ";
		int id = 0;
		
		System.out.println("UserName takes your first and last name as input and returns a valid username in"
				+ " proper format for Doofenshmirtz Evil Inc. employees."); //Prompts can be funny, right?
		
		System.out.println("Please enter your first name: "); //Read user's first and last name
		firstName = scan.nextLine();						  //WARNING: input not validated	
		System.out.println("Please enter your last name: ");
		lastName = scan.nextLine();
		
		id = numGen.nextInt(90) + 10; //generates random number from 0 - 89, then adds 10 giving range of 10 -99
		
		System.out.printf("Your username is %.4s%.1s%d\n", lastName, firstName, id); //print in username format, see printf documentation
		
		scan.close(); //deallocate memory

	}

}
