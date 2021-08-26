package lab8;


class LinkedQ {
	
	private class QNode { //each node is an element of the list.
		public int value; 
		public QNode next;
		public QNode previous;
		
		QNode(int value){
			this.value = value;
			next = null;
			previous = null;			
		}

	}
	
	private QNode front;
	private int size;
	private boolean isEmpty;
	private Exception emptyQueue = new Exception("Queue is empty.");
	
	LinkedQ() {
		this.front = null;
		this.size = 0;
		this.isEmpty = true;
	}
	
	public void enqueue(int value) { //add an element to the end of queue
		if(this.isEmpty) {
			this.front = new QNode(value);
			this.isEmpty = false;
		}
		
		else {
			QNode current = this.front;
			
			while(current.next != null) {
				current = current.next;
			}
			current.next = new QNode(value);
			current.next.previous = current; //link the newly enqueued node back to the previous node
		}
		
		this.size++;
	}
	
	public void dequeue()throws Exception {
		if(this.isEmpty) throw emptyQueue;
		
		else if(this.size == 1) {
			this.front = null;
			this.isEmpty = true;
		}
		
		else {
			this.front = this.front.next;
			this.front.previous = null;
		}
		
		this.size--;
	}
	
	public int first() throws Exception {
		if(this.isEmpty) throw emptyQueue;
		else return this.front.value;
	}
	
	public boolean isEmpty() {
		return this.isEmpty;
	}
	
	public int size() {
		return this.size;
	}
	
	public void removeMiddle() {
		QNode current = this.front;
		for (int i = 0; i < (this.size / 2 - 1); i++) {
			current = current.next;
		}
		current.previous.next = current.next;
		current = null;
		this.size--;
	}
	
}
