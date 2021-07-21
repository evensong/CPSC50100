
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
	
	public void printBox(char c) { //print a Box.size x Box.size box made of a user defined character
		char[] line = new char[this.size];
		
		for (int index = 0; index < line.length; index++) { //initialize all elements of line to c
			line[index] = c; 
		}
		String lineStr = new String(line); //create a string equal to the char array for easy printing
		
		for (int index = 0; index < this.size; index++) {			
				System.out.println(lineStr); 			
		}                                                                       
	}

	public static void main(String[] args) { //Instantiate and print a box of given size
		Box box = new Box();
		int size = 5;
		char element = 'O';
		
		box.setSize(size);
		box.printBox();
		
		System.out.println();
		
		box.printBox(element);

	}

}
