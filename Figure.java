/*
 Ben Haws	7/30/2021	CPSC 50100	Programming Assignment 2 "Figure"
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Figure {
	private int size;
	private char elem = 'X'; //open to ideas on better names for this variable
	private char spacer = ' ';

	public Figure(int size) { //user defined constructor
		this.size = size;
	}
	public Figure() { //default constructor
		this.size = 1;
	}

	public void printBox() { //print a size x size box by filling a 'size' length array with elem characters and printing it size times
		char[] line = new char[this.size];

		for (int i = 0; i < this.size; i++) { //initialize each position in array to 'elem'
			line[i] = this.elem;			
		}

		for (int i = 0; i < this.size; i++) { //print the elements of line

			for (int j = 0; j < this.size; j++) {
				System.out.print(line[j]);
			}
			System.out.println();
		}
	}

	public void printDiamond() { //prints a size x size + 1 vertically symmetrical diamond shape
		for (int i = 0; i < this.size; i++) {

			char[] line = new char[this.size + 1]; //print a diamond by initializing an array for each row of characters with spaces and characters

			for (int j = 0; j < this.size + 1; j++) {

				if (i < this.size / 2 && (j == this.size / 2 - i || j == (this.size + 1) / 2 + i)) {
					line[j] = this.elem;
				} //sets characters in array for upper half of diamond

				else if (i == this.size / 2) { //sets characters for center line of diamond
					line[0] = this.elem; 
					line[size] = this.elem;
				}

				else if (i > this.size / 2 && (j == (i - this.size / 2) || j == this.size - (i - this.size / 2))) {
					line[j] = this.elem;
				}

				else line[j] = this.spacer; //initializes the negative space in the shape

			}
			String lineStr = new String(line);
			System.out.println(lineStr);
		}
	}

	public void printX() { //prints a size x size X shape 
		for (int i = 0; i < this.size; i++) {

			char[] line = new char[this.size];

			for (int j = 0; j < this.size; j++) { //add elements to line at the correct positions

				if (j == i || j == (this.size - 1) - i) line[j] = this.elem; //if the shape is viewed as a matrix, 'elem' is added on the diagonal
				//and off diagonal  
				else line[j] = this.spacer;
			}


			String lineStr = new String(line); //put line array into a string so it can be printed without a loop
			System.out.println(lineStr);
		}
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = 0;
		int option = 0;
		boolean redraw = true;

		System.out.print("Enter the size of the figure (odd number): ");
		
		while (size % 2 == 0)  { //take user input for 'size,' reprompting if a noninteger or an even integer is entered
			boolean valid = false;			
			while (!valid) {
				try {
					size = scan.nextInt();
					valid = true;
				}

				catch (InputMismatchException exception) {
					System.out.print("Invalid figure size - must be an odd number\n\nRe-enter the size of the figure: ");
					scan.next(); //reset after invalid input
					size = 0;
				}
			}

			if (size % 2 == 0) {
				System.out.print("Invalid figure size - must be an odd number\n\nRe-enter the size of the figure: "); 
			}
		}
		
		Figure myFig = new Figure(size);

		do {
			System.out.print("MENU:\n1: Print box\n2: Print diamond\n3: Print x\n4: Quit program\n\n"
					+ "Please select an option: ");
			try {
				option = scan.nextInt(); //have the user select an option, scrubbing noninteger values
			}
			catch(InputMismatchException exception) {
				System.out.println("Invalid input, please select an option: ");
			}
			
			switch (option) { //based on the 
			case 1: myFig.printBox(); break;
			case 2: myFig.printDiamond(); break;
			case 3: myFig.printX(); break;
			case 4: redraw = false; break;
			default: System.out.println("Invalid input, please select an option: "); break;
			}
		} while (redraw);

	}
}
