import java.util.Scanner;

public class DivisorCalc {

	public static int gcd(int num1, int num2) { //implementation of Euclid's greatest common divisor algorithm
		if ((num2 <= num1) && ( num1 % num2 == 0) ) return num2;
		if (num1 < num2) return gcd(num2, num1);
		else return gcd(num2, num1 % num2);
	}
	
	public static void main(String[] args) {
		int input1 = 1;
		int input2 = 1;
		int gcd = 0;
		
		Scanner scan = new Scanner(System.in);
		ArithmeticException badIn = new ArithmeticException();
		
		while (input1 > 0) {
			System.out.println("Please enter a pair of positive integers (enter 0 to quit)");
			try {
				System.out.print("Enter first integer:");
				
				input1 = scan.nextInt();	
				if(input1 == 0) {System.out.println("Goodbye!"); return;} 
				
				System.out.print("Enter second integer: ");
				input2 = scan.nextInt();
				
				if (input1 <= 0 || input2 <= 0) throw badIn; //prevents invalid number input (negatives and zero)
				
				gcd = gcd(input1, input2);
				
				System.out.println("The greatest common divisor is " + gcd);
			}
			catch(Exception e) {
				System.out.println("Error: " + e.getMessage());
				System.out.println("At " + e.getStackTrace());
				System.out.println("Please enter another pair of integers\n");
				scan.next();
			}
		}
		scan.close();

	}

}
