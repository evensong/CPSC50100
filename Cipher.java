/*
 Ben Haws		CPSC50100		Summer 2021		Programming Assignment #1 (Cipher)
 */
import java.util.Scanner;
import java.util.Random;

public class Cipher {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random keyGen = new Random();
		
		final int UPPER_BOUND = 19; //program not usable for numbers with more than two digits
		final int LOWER_BOUND = 0;  //program assumes base 10 counting
		
		int input = 0;
		int plainText = 0;
		int key = keyGen.nextInt(10); //set the key value to a random number
		int tens = 0; //plainText will be separated into two digits, one for the tens place 
		int ones = 0; //the other for the ones place
		int cipherText = 0;
		
		System.out.println("Welcome To Caesar Cipher! Enter 5 integers "
				+ "from " + LOWER_BOUND + " to " + UPPER_BOUND + " to see "
				+ "their sum encoded with a randomly generated key.\n");
		
		int i = 0; //iteration tracker. NOTE: The while loop should really be a for loop to improve readability
		
		while (i < 5) { //reads 5 user input integers and adds them together in plainText
			System.out.println("Please enter an integer between " + LOWER_BOUND +" and " + UPPER_BOUND);
			input = scan.nextInt();
			
			if (input >= LOWER_BOUND && input <= UPPER_BOUND) { //Ensure user input is within correct range. NOTE: Does not validate noninteger input
				plainText += input;
				input = 0; 				//After adding input to plainText, we reset input so we only need one input variable
				i++;
			}
			else {
				System.out.println("Please read directions and try again!");
				input = 0;
			}
		}
			
		
		System.out.println("The sum of your input is: " + plainText + "\nWe will encode it using " + key +" as the key");
		
		//Encoding sequence: for each digit of plainText, add key then %10 the sum
		tens = (plainText / 10 + key) % 10; //10 is here because our numbers are base 10. I think declaring a constant would make this harder to read.
		ones = (plainText % 10 + key) % 10; //but if we were writing a more general program, we should definitely do so.
		cipherText = tens * 10 + ones; 
		
		System.out.println("Your encoded value is " + cipherText);
		
		scan.close();
	}

}
