package lab7;

class ArrayStack { //this stack is only works for int variables
	
	private int totalSize = 100;
	private int currentSize = 0;
	private boolean isEmpty = true;
	
	private int[] stack = new int[totalSize];
	
	public void push(int input) { //add a variable to the top of the stack
		
		if (this.isEmpty) {this.stack[0] = input; this.isEmpty = false;} //add element to empty stack, simplest case
		
		else {
			this.stack[currentSize] = input;
		}
		
		this.currentSize++;
	}
	
	public void pop() {
		if(this.isEmpty) System.out.println("Error: Stack Empty");
		else {
			this.stack[currentSize - 1] = 0;
			currentSize--;
			
			if(this.currentSize == 0) this.isEmpty = true;
		}
	}
	
	public int peek() {  //show top element of stack
		if(this.isEmpty) { System.out.println("Error: Stack Empty."); return 0;}
		else return stack[currentSize - 1];
	}
	
	public boolean isEmpty() {
		return this.isEmpty;
	}
	
	public int size() {
		return this.currentSize;
	}
	
	
}
