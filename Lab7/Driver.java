package lab7;

public class Driver {
	

	public static void main(String[] args) {
		ArrayStack aStack = new ArrayStack();
		LinkedStack lStack = new LinkedStack();
		
		int[] nums = {1,7,3,4,9,2};
		
		for (int i = 0; i < nums.length; i++) { //initialize stack
			aStack.push(nums[i]);
		}
		
		System.out.println("Test Array Stack");
		
		while(!aStack.isEmpty()) { //print the value at the top and then pop it
			System.out.println(aStack.peek());
			aStack.pop();
		}
		
		for (int i = 0; i < nums.length; i++) { 
			lStack.push(nums[i]);
		}
		
		System.out.println("Test Linked Stack");
		
		while(!lStack.isEmpty()) {
			System.out.println(lStack.peek());
			lStack.pop();
		}
		
		System.out.println("Test removeBottomHalf()");
		for (int i = 0; i < nums.length; i++) {
			lStack.push(nums[i]);
		}
		
		lStack.removeBottomHalf();
		while(!lStack.isEmpty()) {
			System.out.println(lStack.peek());
			lStack.pop();
		}
		
		

	}

}
