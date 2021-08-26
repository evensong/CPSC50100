package lab8;

public class Driver {
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,7,3,4,9,2};
		LinkedQ lQ = new LinkedQ();
		ArrayQ aQ = new ArrayQ();
		
		for(int i = 0; i < nums.length; i++) {
			lQ.enqueue(nums[i]);
		}
		
		System.out.println("Test LinkedQ");
		try {
			int size = lQ.size(); //declared here to avoid loop troubles as size changes
			
			for(int i = 0; i < size; i++) {
				System.out.println(lQ.first());
				lQ.dequeue();
			}
			
			System.out.println("Test removeMiddle"); //repeat test sequence including the removeMiddle function
			for(int i = 0; i < nums.length; i++) {
				lQ.enqueue(nums[i]);
			}
			
			lQ.removeMiddle();
			
			size = lQ.size();
			for(int i = 0; i < size; i++) {
				System.out.println(lQ.first());
				lQ.dequeue();
			}
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		System.out.println("Test ArrayQ");
		
		try {
			for(int i = 0; i < nums.length; i++) {
				aQ.enqueue(nums[i]);
			}

			int size = aQ.size(); //declared here to avoid loop troubles as size changes

			for(int i = 0; i < size; i++) {
				System.out.println(aQ.first());
				aQ.dequeue();
			}			
			
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
