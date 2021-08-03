import java.util.Scanner;
import java.io.BufferedWriter; //make writing more efficient. Not strictly necessary for this program, but good for file read/write in general
import java.io.FileWriter;
import java.io.IOException;

public class StringReader {

	public static void main(String[] args) { //Writes user input to file "userStrings.txt" Overwrites anydata already there, so be warned
		Scanner scan = new Scanner(System.in);
		String inputString = null;
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("userStrings.txt")); //bufferedwriter created using a filewriter object
			
			while (!(inputString = scan.nextLine()).equals("DONE")) { //.equals() used to make sure the values of the strings are compared
				out.write(inputString);
				out.newLine();
				out.flush(); //clear the buffer before another line is put in
				
				System.out.println("WRITTEN SUCCESSFULLY");
			}	
			
			out.close(); //close filestream before program ends
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		finally {
			scan.close();
		}

	}

}
