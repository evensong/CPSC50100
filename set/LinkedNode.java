package set;

class LinkedNode {
	 LinkedNode next;
	 int value;
	
	LinkedNode(int value){
		this.next = null;
		this.value = value;
	}
	
	LinkedNode(){
		this.next = null;
		this.value = 0;
	}
}
