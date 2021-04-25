/*

!           Remove Min

Implement the function RemoveMin for the min priority queue class.
For a minimum priority queue, write the function for removing the minimum 
element present. Remove and return the minimum element.
Note : main function is given for your reference which we are using 
internally to test the code.
*/

import java.util.ArrayList;


// Main function - 
	public static void main(String[] args) {
		PQ pq = new PQ();
		int choice = s.nextInt();
		while(choice != -1) {
			switch(choice) {
				case 1 : // insert
					int element = s.nextInt();
					pq.insert(element);
					break;
				case 2 : // getMin
				try {
					System.out.println(pq.getMin());
				} catch (PriorityQueueException e) {
					return;
				}
					break;
				case 3 : // removeMin
				try {
					System.out.println(pq.removeMin());
				} catch (PriorityQueueException e) {
					return;
				}
					break;
				case 4 : // size
					System.out.println(pq.size());
					break;
				case 5 : // isEmpty
					System.out.println(pq.isEmpty());
				default :
						return;
			}
			choice = s.nextInt();
		}
	}




public class PQ {

	private ArrayList<Integer> heap;

	public PQ() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty(){
		return heap.size() == 0;
	}

	int size(){
		return heap.size();
	}

	int getMin() throws PriorityQueueException{
		if(isEmpty()){
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element){
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while(childIndex > 0){
			if(heap.get(childIndex) < heap.get(parentIndex)){
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			}else{
				return;
			}
		}
	}

	int removeMin() throws PriorityQueueException{

        if(heap.isEmpty()) {
			throw new PriorityQueueException();
		}
		
		int ans = heap.get(0);
		 
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int parentIdx = 0;
		int leftIdx = 2*parentIdx + 1;
		int rightIdx = 2*parentIdx + 2;
		
		while(leftIdx < heap.size())
		{
			int minIdx = parentIdx;
			
			if(heap.get(leftIdx) < heap.get(minIdx) )
				minIdx=leftIdx;
			
			if( rightIdx < heap.size() && heap.get(rightIdx) < heap.get(minIdx))
				minIdx=rightIdx;
			
            if( minIdx == parentIdx)
                break;
            
			Integer temp = heap.get(minIdx);
			heap.set(minIdx, heap.get(parentIdx));
			heap.set(parentIdx, temp);
			parentIdx = minIdx;
			leftIdx = 2*parentIdx + 1;
			rightIdx = 2*parentIdx +2;
		}
		
		return ans;
	}
}

class PriorityQueueException extends Exception {

}