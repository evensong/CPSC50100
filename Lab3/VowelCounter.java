//Lab 3 Exercise 3   Dedicated to my favorite tester, my wife Aubrey

import java.util.Scanner;

public class VowelCounter { 
	
	static private int countLowerVowels(String input) { //count lowercase vowels within input string
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};		
		int countA = 0, countE = 0, countI = 0, countO = 0, countU = 0; //count individual vowels
		
		if (input.length() == 0) { //protect against null strings
			return (countA + countE + countI + countO + countU);
		}

		for (int index = 0; index < input.length(); index++) { //iterate through each character in input

			for (int index2 = 0; index2 < vowels.length; index2++) { //check character against each vowel

				if (input.charAt(index) == vowels[index2]) { //if character matches the vowel, increment count	
					
					switch (index2) {	//decide which vowel needs to get incremented based on vowels index
					case 0: countA++; break; 
					case 1: countE++; break; 
					case 2: countI++; break;
					case 3: countO++; break;
					case 4: countU++; break;
					}
				}					
			}
		}
		
		System.out.println("Detected " + countA + " a('s), " + countE + " e('s), " + countI + " i('s), "
				+ countO + " o('s), and " + countU + " u('s).");
		return (countA + countE + countI + countO + countU); //return sum of all vowels (vowels summed per assignment spec)
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
			System.out.println("\nCounting lowercase vowels.");
			vowels = countLowerVowels(input);
			
			System.out.println("\nCounting all vowels to calculate number of nonvowel characters.");
			nonVowels = input.length() - countLowerVowels(input.toLowerCase());

			System.out.print("\nYour string has " + vowels + " vowels and " + nonVowels
					+ " nonvowel characters.\nEnter a new string (type \"exit\" to close): ");
			input = scan.nextLine();
		}
		
		System.out.println("Goodbye!");
		scan.close();
	}

}
