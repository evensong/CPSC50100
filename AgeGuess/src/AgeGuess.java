//Exercise 1 of Week 2 lab
//Ben Haws

import java.util.Scanner;
import java.util.Random;

public class AgeGuess {

	public static void main(String[] args) {
        String name;
        Random ageGen = new Random();

        int ageGuess = 0;
        int age = ageGen.nextInt(101); //bound is 101 because the range is 0 to bound-1
        Scanner scan = new Scanner(System.in);
   

        System.out.println("Enter name: "); //Prompt and read in name and age guess
        name = scan.nextLine();

        System.out.println("Enter an age guess: ");
        ageGuess = scan.nextInt(); //WARNING: User input not validated

        System.out.println("You guessed that " + name + " is " + ageGuess + " years old.");
        
        if (ageGuess == age) {
        	System.out.println("That is correct!");
        }
        else
        	System.out.println("That is incorrect. " + name + " is " + age + " years old.");
        
        scan.close(); //deallocate memory--not strictly necessary, but it makes Eclipse happy

	}

}
