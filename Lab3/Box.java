
public class Box {
	private int size = 0;
	
	public void setSize(int size) { //size mutator
		this.size = size; //this.size refers to the object's size variable and size refers to the parameter
	}
	
	public void printBox() { //print a Box.size x Box.size box of asterisks
		String star = "*";
		
		for (int index = 1; index <= this.size; index++) {			
				System.out.println(star.repeat(this.size)); 			
		}                                                                       
	}

	public static void main(String[] args) { //Instantiate and print a box of given size
		Box box = new Box();
		int size = 5;
		
		box.setSize(size);
		box.printBox();

	}

}
