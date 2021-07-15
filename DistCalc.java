import java.util.Scanner; //math functions are automatically imported with java.lang
import java.text.DecimalFormat;

public class DistCalc {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DecimalFormat form = new DecimalFormat("0.###");
		
		double x1 = 0; //coordinate pairs in R2
		double y1 = 0;
		double x2 = 0; 
		double y2 = 0;
		
		double distance = 0;		
		double xComp = 0; //variables used to break the distance calculation into more readable parts
		double yComp = 0;
		
		System.out.println("DistCalc returns the distance between two points on a 2D plane.");
		
		System.out.println("Please enter the X coordinate of the first point:"); //prompt for and read in coordinates
		x1 = scan.nextDouble();		
		System.out.println("Please enter the Y coordinate of the first point:");
		y1 = scan.nextDouble();		
		System.out.println("Please enter the X coordinate of the second point:");
		x2 = scan.nextDouble();		
		System.out.println("Please enter the Y coordinate of the first point:");
		y2 = scan.nextDouble();
		
		xComp = Math.pow((x2 - x1), 2);//distance calculation, broken into parts for readability
		yComp = Math.pow((y2 - y1), 2);
		distance = Math.sqrt(xComp + yComp);
		
		System.out.println("The distance between these points is " + form.format(distance));
		
		scan.close(); //memory deallocation

	}

}
