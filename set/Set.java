package set;

class Set {
	private LinkedNode front;
	private Exception emptySet = new Exception("This set is empty");
	
	private boolean isEmpty;
	private int size;
	
	Set(){
		this.front = null;
		this.isEmpty = true;
		this.size = 0;
	}
	
	//add specified integer value to the set then print Set
	public void add(int value) {
		if (this.isEmpty) {
			front = new LinkedNode(value);
			this.isEmpty = false;
		}
		
		else {
			LinkedNode current = front;
			
			while (current.next != null) {
				current = current.next;
			}
			
			current.next = new LinkedNode(value);
		}
		
		this.size++;
		System.out.println(this.toString());
	}
	
	//delete first of the given value in the Set, then print Set
	public void delete(int value) throws Exception{
		LinkedNode current = front;
		LinkedNode prev = null;
		
		if (this.isEmpty) throw emptySet;
		
		if (!this.exists(value)) { // If value does not exist in set abort
			System.out.println("Value not found.");
			return;
		}
		
		if(front.value == value && front.next == null) { //delete front & empty Set if the only value in the set is the one to be deleted
			front = current = null;
			this.isEmpty = true;
		}
		
		else {
			for (int i = 0; i < this.size; i++) {
				
				if (current.value == value) {
					
					if (current == front) front.next = front; //if the value is in front node, there will be no previous node to link to
					
					else {
						prev.next = current.next;
						current = null;
						break;
					}
				}
				prev = current;
				current = current.next;
			}
		}
		
		this.size--;
		System.out.println(this.toString());
	}
	
	
	//traverse the Set and return true if the given value is present (at least once)
	public boolean exists(int value) throws Exception{
		boolean present = false;
		LinkedNode current = front;
		
		if (this.isEmpty) throw emptySet;
		
		for (int i = 0; i < this.size; i++) {
			if (current.value == value) present = true;
			current = current.next;
		}
		
		return present;
	}
	
	//return all members of Set as space separated String;
	public String toString() {
		String[] set = new String[this.size];
		LinkedNode current = front;
		
		if (current == null) return "Set empty.";
		
		for (int i = 0; i < set.length; i++) {
			set[i] = Integer.toString(current.value);
			current = current.next;
		}
		
		return String.join(" ", set);
	}
}
