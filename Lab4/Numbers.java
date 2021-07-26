
public class Numbers {
	private int size;
	private int[] numbers;
	
	Numbers(int size, int[] numbers) {
		this.size = size;
		this.numbers = numbers;
	}
	
	public int[] nextLargest() {
		int[] nextLargest = new int[this.size];
		
		for (int index1 = 0; index1 < this.size; index1++) {
			nextLargest[index1] = Integer.MAX_VALUE; //initialize to MAX_VALUE in case there is no larger element
			
			for (int index2 = 0; index2 < this.size; index2++) {
				
				if (this.numbers[index1] < this.numbers[index2]) { //search for larger element
					
					nextLargest[index1] = this.numbers[index2];
					int margin = numbers[index1] - numbers[index2]; //calculate by how much it is larger
					
					for (int index3 = 0; index3 < this.size; index3++) { //search for an element that is larger by the smallest margin
						
						int difference = numbers[index1] - numbers[index3]; 
						
						if((Math.abs(difference) < Math.abs(margin)) && numbers[index3] > numbers[index1]  ) {
							nextLargest[index1] = numbers[index3]; //find value that is larger by the smallest margin
							margin = difference; //if a larger number with a smaller margin of difference is found, set margin to that difference to search for a smaller margin
						}
					}
				}
			}
		}
		
		return nextLargest;
	}

	public static void main(String[] args) {
		int[] numbers = {2, 3, 1, 6, 7, 66, 90, 4, 32};
		int size = 9;
		
		Numbers myNums = new Numbers(size, numbers);
		int[] nextLargest = myNums.nextLargest();
		
		for (int index = 0; index < size; index++) {
			System.out.println(numbers[index] + ":" + nextLargest[index]);
		}
		

	}

}
