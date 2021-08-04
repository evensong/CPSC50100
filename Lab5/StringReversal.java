import java.util.Scanner;

public class StringReversal {
	
	public static String reverseString(String s) {
		if (s.length() == 1) return s; //terminator condition, a string of length 1 is palindromic
		else {
		return s.charAt(s.length() - 1) + reverseString(s.substring(0 , s.length() - 1)); //makes the last character first, then calls reverse string on the rest
		}
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = " ";
		
		while (!s.equals("done")) {
			System.out.print("Please enter a string to be reversed (type \"done\" to exit): ");
			s = scan.nextLine();
			
			if (s.equals("done")) System.out.println("Goodbye!"); //To make it clear that the program is exiting
			else System.out.println(reverseString(s));
			
		}
		scan.close();
	}

}
