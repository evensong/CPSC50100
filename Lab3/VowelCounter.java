//Lab 3 Exercise 3   Dedicated to my favorite tester, my wife Aubrey

import java.util.Scanner;

public class VowelCounter { 
	
	static private int countLowerVowels(String input) { //count lowercase vowels within input string
		int vowelsCount = 0;
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		
		int countA = 0, countE = 0, countI = 0, countO = 0, countU = 0; //count individual vowels
		
		if (input.length() != 0) { 
			
			for (int index = 0; index < input.length(); index++) { //iterate through each character in input

				for (int index2 = 0; index2 < vowels.length; index2++) { //at current input index, check if each vowel is present
					
					if (input.charAt(index) == vowels[index2]) {
						vowelsCount++;
						switch (index2) {
						case 0: countA++; break; 
						case 1: countE++; break;
						case 2: countI++; break;
						case 3: countO++; break;
						case 4: countU++; break;
						}
					}
					
				}

			}
		}
		System.out.println("Detected " + countA + " a('s), " + countE + " e('s), " + countI + " i('s), "
				+ countO + " o('s), and " + countU + " u('s).");
		return vowelsCount;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = " ";
		
		int vowels = 0;
		int nonVowels = 0;
		
		System.out.print("Vowel counter will read any string and count how many lowercase vowels"
				+ " and nonvowel characters it contains.\nEnter string (type \"exit\" to close): ");
		input = scan.nextLine();
		
		while (!input.equalsIgnoreCase("exit")) { //user types "exit" to exit program
			System.out.println("Counting lowercase vowels.");
			vowels = countLowerVowels(input);
			
			System.out.println("Counting all vowels to calculate number of nonvowel characters.");
			nonVowels = input.length() - countLowerVowels(input.toLowerCase());

			System.out.print("Your string has " + vowels + " vowels and " + nonVowels
					+ " nonvowel characters.\nEnter a new string (type \"exit\" to close): ");
			input = scan.nextLine();
		}
		
		System.out.println("Goodbye!");
		scan.close();
	}

}
