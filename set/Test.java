package set;

import java.util.Scanner;

public class Test {
	private static Exception invalidCommand = new Exception("Command invalid.");
	
	private static String getCommand(String input) throws Exception {
		if (input.contains("add")) return "add";
		else if (input.contains("del")) return "del";
		else if (input.contains("exists")) return "exists";
		else throw invalidCommand;
	}


	public static void main(String[] args) {
		Set userSet = new Set();
		Scanner scan = new Scanner(System.in);
		
		String userIn;
		String command;
		int value;
		
		System.out.println("Programming Fundamentals\nNAME: Ben Haws\nPROGRAMMING ASSIGNMENT 4 - SET");
		
		while (true) {
			try {
				System.out.print("Enter command: ");
				userIn = scan.nextLine();
				
				command = getCommand(userIn);
				userIn = userIn.replaceAll("\\D+", "");
				value = Integer.parseInt(userIn);
				
				
				if (command.equals("add")) userSet.add(value);
				if (command.equals("del")) userSet.delete(value);
				if (command.equals("exists")) System.out.println(userSet.exists(value));
				
			}
			catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
