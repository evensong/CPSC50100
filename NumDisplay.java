import java.util.Scanner;

public class NumDisplay {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		String numString = ""; //this string will typically read a number, but can also be used to display error messages
		
		System.out.println("NumDisplay reads any integer from 0 - 9 and prints it as a number.");
		
		while (num != 13) { 	//for easy debugging, you can keep entering ints to check all values
			System.out.println("Please enter an integer between 0 and 9 (13 to quit): "); //Sentinel = 13
			num = scan.nextInt();

			switch (num) {
			case 0:  numString = "Zero"; //Does anyone know a way to enter case statements less manually? Very boring.
			break;
			case 1: numString = "One";
			break;
			case 2: numString = "Two";
			break;
			case 3: numString = "Three";
			break;
			case 4: numString = "Four";
			break;
			case 5: numString = "Five";
			break;
			case 6: numString = "Six";
			break;
			case 7: numString = "Seven";
			break;
			case 8: numString = "Eight";
			break;
			case 9: numString = "Nine";
			break;
			case 13: numString = "Goodbye!"; //This is the quit case
			break;
			default: numString = "Error, invalid input detected.";
			}
			
			System.out.println(numString);	//print num as string (or special case message) Note that this is within the while loop		
		}

		scan.close();
	}
		
}
