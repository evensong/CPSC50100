package lab8;

class ArrayQ {
	private Exception emptyQueue = new Exception("Queue is empty.");
	private Exception fullQueue = new Exception("Queue is full. Overwriting currently not implemented.");
	
	private int count;
	private int size = 100; //the actual size of the circular array
	
	private int readIndex; //readIndex is equivalent to the front of the array
	private int writeIndex; //write index is at the rear behind the last element
	
	private boolean isEmpty;
	private boolean isFull; //to prevent overwriting
	
	private int[] items = new int[this.size];
	
	ArrayQ(){
		this.count = 0;
		this.isEmpty = true;
		this.isFull = false;
		this.writeIndex = 0;
	}
	
	public void enqueue(int value) throws Exception {
		if(this.isEmpty) {
			items[writeIndex] = value;
			this.readIndex = this.writeIndex;
			this.isEmpty = false;
		}
		
		else if(this.isFull) throw fullQueue;
		
		else {
			items[writeIndex] = value;
		}
		this.writeIndex = (writeIndex + 1) % this.size; //increment the write index, but wrap if it would be higher than the array's upper bound
		this.count++;
		
		if(this.readIndex == this.writeIndex && !this.isEmpty) this.isFull = true; //test if circular array is full
	}
	
	public void dequeue() throws Exception {
		if(this.isEmpty) throw emptyQueue;
		
		else if(this.count == 1) {
			this.isEmpty = true;
		}
		
		this.readIndex = (this.readIndex + 1) % this.size; //an item is dequeued not by deleting it, but by moving the index away. 
		this.count--;
	}
	
	public int first() throws Exception{
		if (this.isEmpty) throw emptyQueue;
		else return items[readIndex];
	}
	
	public boolean isEmpty() {
		return this.isEmpty;
	}
	
	public int size() {
		return this.count;
	}
}
