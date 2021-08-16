package lab7;

class LinkedStack {
	
	private class StackNode { //each node is an element of the list.
		public int value; 
		public StackNode next;
		public StackNode previous;
		
		StackNode(int value){
			this.value = value;
			next = null;
			previous = null;			
		}

	}
	
	
	private StackNode bottom; 
	private boolean isEmpty;
	private int size;
	
	LinkedStack(){
		this.bottom = null;
		this.isEmpty = true;
		this.size = 0;
	}
	
	public void push(int value) { //add an element to the stack by linking it to the list
		StackNode node = new StackNode(value);
		StackNode current;
		
		if (this.isEmpty()) {
			this.bottom = node;
			this.isEmpty = false;
		}
		else {
			current = this.bottom;
			
			while (current.next != null) { //travel down the links of the list until we get to the end (top of the stack)
				current = current.next;
			}
			current.next = node; //link the element at the top to the new element we created
			current.next.previous = current; //link the new element back to the previous top
		}
		this.size++;
	}
	
	public void pop() {
		if (this.isEmpty) { System.out.println("Error: Stack Empty"); return;}
		else if (this.size == 1) this.bottom = null;
		else {
			StackNode current = this.bottom;
			
			while (current.next != null) { //travel from the bottom to the top of the stack
				current = current.next;
			}
			current = current.previous; //backtrack one from the top of the stack
			current.next = null; //delete the item from the top of the stack
		}
		this.size--;
		if(this.size == 0) this.isEmpty = true;
	}
	
	public int peek() {
		StackNode current = bottom;
		
		if (this.isEmpty()) {
			System.out.println("Error: Stack Empty"); 
			return 0000;
		}
		else {
			while (current.next != null) current = current.next;
			return current.value;
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.isEmpty;
	}	
	
	public void removeBottomHalf() {
		int size = this.size;
		for (int i = 0; i < this.size / 2; i++) {
			this.bottom = this.bottom.next;
			this.bottom.previous = null;
			size--; //track the changes in size without messing with the for loop
		}
		this.size = size; //change the size based on how many removals there were
	}

}
