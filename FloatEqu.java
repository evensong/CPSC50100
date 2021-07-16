
public class FloatEqu {
	static final double TOLERANCE = 0.00001;
	
	public static void main(String[] args) {
		double example1 = ((1.0/10) * (1.0/10)); //calculate the same value of double using two methods
		double example2 = (1.0/100);
		
		if (example1 == example2) {
			System.out.println("Equal");
		}
		else System.out.println("Not Equal"); //precision of calculation not high enough for exact equivalence
		
		if (Math.abs(example1 - example2) <= TOLERANCE) { //if the absolute difference of the values is less than 0.00001,
			System.out.println("But Equal Enough");       //they are close enough for most applications  
		}
		else System.out.println("Definitely Not Equal");

	}

}
