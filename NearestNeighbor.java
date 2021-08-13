import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class NearestNeighbor {

	public final static int ROWS = 75;
	public final static int COLS = 5;
	
	private static int min(double[] values) { //return the index of the smallest element of an array--the smallest distance is the nearest neighbor
		double minValue = values[0];
		int minIndex = 0;
		
		for(int i = 0; i < values.length; i++) {
			if(minValue > values[i]) {
				minIndex = i;
				minValue = values[i];
			}
		}
		
		return minIndex;
	}
	
	private static double distance(double[] x, double[] y) { //use linear distance formula to find the distance between two arrays (treated as vectors)
		double sepalLengths = Math.pow(((x[0] - y[0])), 2); //find each square and then take root, to improve readability
		double sepalWidths = Math.pow(((x[1] - y[1])), 2);
		double petalWidths = Math.pow(((x[2] - y[2])), 2);
		double petalLengths = Math.pow(((x[3] - y[3])), 2);
		
		double distance = Math.sqrt(sepalLengths + sepalWidths + petalWidths + petalLengths);
		
		return distance;
	}
	
	public static double[] getDistances(double[] test, double[][] train) {
		double[] distances = new double[ROWS];
		
		for (int i = 0; i < train.length; i++) {
			distances[i] = distance(test, train[i]); //calculate the distance of the test instance from every training instance
			
		}
		
		return distances;
	}
	
	public static String[] classify(double[][] test, double[][] train, String[] species) { //classify each test element, return results as an array
		String[] classification = new String[ROWS];
		for(int i = 0; i < ROWS; i++) {
			classification[i] = species[min(getDistances(test[i], train))]; //classification is the species at the index corresponding to the minimum distance
		}
		
		return classification;
	}
	
	public static double[][] getData(String fileName) throws IOException { //read data from training/test file into 2D array of doubles--
		BufferedReader read = new BufferedReader(new FileReader(fileName)); //NOTE: limited to the iris dataset's format
		
		double[][] data = new double[ROWS][COLS - 1];
		String line = " ";
		
		for(int i = 0; i < data.length; i++) {
			line = read.readLine();
			String[] values = line.split(",");
			
			for(int j = 0; j < data[i].length; j++) { //note that because the length of each subarray is 1 less than COLS, we will not parse the class
				data[i][j] = Double.parseDouble(values[j]);
			}
		}
		
		read.close();
		return data;
	}
	
	public static String[] getClass(String fileName) throws IOException { //read the last element of each row to get the name of the class for each row
		BufferedReader read = new BufferedReader(new FileReader(fileName)); //heavily borrows from getData
		
		String[] classes = new String[ROWS];
		String line = " ";
		
		int index = 0;
		while((line = read.readLine()) != null) {
			String[] values = line.split(",");
			classes[index] = values[COLS - 1]; //add the last element of values--ie the class--to the classes array
			
			index++;
		}
		
		read.close();
		return classes;
	}
	
	
	public static void showResults(String[] actual, String[] prediction) { //put all of the formatting in one place so it doesn't clog main()
		int correct = 0;
		double accuracy = 0;
		
		System.out.println("EX#: TRUE LABEL, PREDICTED LABEL");
		
		for(int i = 0; i < actual.length; i++) {
			System.out.println((i + 1) + ": " + actual[i] + " " + prediction[i]);
			if(actual[i].equals(prediction[i])) correct++;
		}
		
		accuracy = ((double) correct / (double) ROWS) * 100;
		System.out.println("\nACCURACY: " + accuracy);
	}
	
	public static void main(String[] args) {
		String trainingFile = " "; 
		String testingFile = " ";
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Programming Fundamentals\nNAME: Ben Haws\nPROGRAMMING ASSIGNMENT 3\n");
				
		try {
			System.out.print("Enter the name of the training file: ");
			trainingFile = scan.next();
			double[][] trainingData = NearestNeighbor.getData(trainingFile); //Initialize data and classes for testing and training sets
			String[] trainingClasses = NearestNeighbor.getClass(trainingFile);
			
			System.out.print("Enter the name of the testing file: ");
			testingFile = scan.next();
			double[][] testingData = NearestNeighbor.getData(testingFile);
			String[] testingClasses = NearestNeighbor.getClass(testingFile);
			
			String[] predictions = classify(testingData, trainingData, trainingClasses);
			
			showResults(testingClasses, predictions);			
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
		scan.close();

	}

}
