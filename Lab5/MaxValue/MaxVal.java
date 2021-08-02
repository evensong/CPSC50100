import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;


public class MaxVal {

	public static void main(String[] args) { //reads an input csv file and outputs the largest value in each row
		String line = null;
		ArrayList<int[]> data = new ArrayList<>(); //create an ArrayList of int arrays, one array for each row of input
		
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("input.csv")); 
			
			while((line = in.readLine()) != null) { //read in each line of the input file into "data" 
				
				String[] values = line.split(","); //split the line around the commas, and store the values in a String array, to be converted to int
				int[] intValues = new int[line.length()];
				
				for (int i = 0; i < values.length; i++) { //convert string array "values" into int array "intValues"
					intValues[i] = Integer.parseInt(values[i]);
				}
				
				data.add(intValues); //add the line of input, data will be a list of arrays corresponding to the rows in the input file	
			}
			
			System.out.println("Maximum values:");
			
			for (int i = 0; i < data.size(); i++) { //iterate over all elements of data, set maxValue to highest in each row, then print
				int maxValue = 0;
				for (int j = 0; j < data.get(i).length; j++) {
					if (maxValue < data.get(i)[j]) maxValue = data.get(i)[j]; //specifies jth element of the ith row/array of data
				}
				
				System.out.println("Row " + (i + 1) + ": " + maxValue); 
			}
			
			in.close();
		}
		catch(IOException e) { 
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

	}

}
