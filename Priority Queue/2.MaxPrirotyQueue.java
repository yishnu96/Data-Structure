/*

!           Code : Max Priority Queue

Implement the class for Max Priority Queue which includes following functions -
1. getSize -
Return the size of priority queue i.e. number of elements present in the priority queue.
2. isEmpty -
Check if priority queue is empty or not. Return true or false accordingly.
3. insert -
Given an element, insert that element in the priority queue at the correct position.
4. getMax -
Return the maximum element present in the priority queue without deleting. Return -Infinity if 
priority queue is empty.
5. removeMax -
Delete and return the maximum element present in the priority queue. Return -Infinity if priority 
queue is empty.
Note : main function is given for your reference which we are using internally to test the class.
*/


import java.util.ArrayList;

 
 //* Following is the main function for your reference which we are using internally.
 
 public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		int choice = s.nextInt();
		while(choice != -1) {
			switch(choice) {
				case 1 : // insert
					int element = s.nextInt();
					pq.insert(element);
					break;
				case 2 : // getMax
					System.out.println(pq.getMax());
					break;
				case 3 : // removeMax
					System.out.println(pq.removeMax());
					break;
				case 4 : // size
					System.out.println(pq.getSize());
					break;
				case 5 : // isEmpty
					System.out.println(pq.isEmpty());
				default :
						return;
			}
			choice = s.nextInt();
		}
	}
// ************/

public class PriorityQueue {
private ArrayList<Integer> heap;
	
	public PriorityQueue(){
		heap = new ArrayList<Integer>();
	}

	public void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while(childIndex > 0){
			if(heap.get(childIndex) > heap.get(parentIndex))
			{
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			}
			else
				return;

		}
	}
	
	public void print() {
		
		for(int i=0;i<heap.size();i++)
			System.out.println(heap.get(i)+" ");
	}

	public int getMax() {
		if(isEmpty()){
			// Throw an exception
			return Integer.MAX_VALUE;
		}
		return heap.get(0);
	}

	public int removeMax() {
		if(heap.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		
		int ans = heap.get(0);
		 
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int parentIdx = 0;
		int leftIdx = 2*parentIdx + 1;
		int rightIdx = 2*parentIdx + 2;
		
		while(leftIdx < heap.size())
		{
			int maxIdx = parentIdx;
			
			if(heap.get(leftIdx) > heap.get(maxIdx) )
				maxIdx=leftIdx;
			
			if( rightIdx < heap.size() && heap.get(rightIdx) > heap.get(maxIdx))
				maxIdx=rightIdx;
			
            if( maxIdx == parentIdx)
                break;
            
			Integer temp = heap.get(maxIdx);
			heap.set(maxIdx, heap.get(parentIdx));
			heap.set(parentIdx, temp);
			parentIdx = maxIdx;
			leftIdx = 2*parentIdx + 1;
			rightIdx = 2*parentIdx +2;
		}
		
		return ans;
	}

	public int getSize() {
		return heap.size();
	}

	public boolean isEmpty() {
		return heap.size() == 0;
	}
	
}
