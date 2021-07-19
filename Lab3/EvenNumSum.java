import java.util.Scanner;
public class EvenNumSum {
	public static final int EVEN = 2; 
	public static final int ODD = 1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		long input = 0; //This variable will keep its value so we can display it with the user's results
		long input2 = 0; //We will set this equal to input and use it as a proxy for our arithmetic
		long sum = 0;
		
		System.out.print("Welcome to EvenNumSum!\nEnter an integer to calculate the sum of "
				+ "all even numbers between that number and 2!\nYour integer must be greater "
				+ "than or equal to 2. Enter 0 to quit.\nEnter integer here: ");
		input = scan.nextLong(); //WARNING: User input not validated. Breaks at noninteger input and long overflow
		
		while (input != 0) { //Set 0 as exit value
			
			if (input >= EVEN) { //Verify user input is in proper range
				input2 = input; //Set input2 equal to most recent input
				sum = 0;

				if ((input2 % EVEN) != 0) input2--; //if input is not even, subtract 1 to make it even

				while(input2 >= 2) { //add input to the sum, then subtract EVEN (2) from input to get next even int
					sum += input2;
					input2 -= EVEN;
				}

				System.out.print("The sum of all even integers between " + EVEN + " and " + input 
						+ " is " + sum + ".\nEnter another integer:");
				input = scan.nextLong();

			}
			else { //Reprompt if user input out of range
				System.out.print("Invalid input, enter an integer greater than or equal to 2:");
				input = scan.nextLong();
			}			
		}
		
		System.out.println("\nGoodbye!");
		
		scan.close();
	}

}
