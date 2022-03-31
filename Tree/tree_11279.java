import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class tree_11279 {
	static public ArrayList<Integer> heap;
	static class MaxHeap{
		MaxHeap(){
			heap = new ArrayList<Integer>();
			heap.add(0);
		}
		
		public void insert(int value) {
			heap.add(value);
			int pos = heap.size() - 1; // value index
			
			while(pos > 1 && heap.get(pos) > heap.get(pos/2)) {
				//swap
				int tmp = heap.get(pos/2);
				heap.set(pos/2, heap.get(pos));
				heap.set(pos, tmp);
				pos /= 2;
			}	
		}
		
		public int delete() {
			if(heap.size()-1 < 1) {
				return 0;
			}
			int value = heap.get(1);
			int end = heap.size()-1;
			
			heap.set(1,heap.get(end));
			heap.remove(end);
			
			int pos = 1;
			while((pos * 2) < heap.size()){
				int max = heap.get(pos * 2);
				int maxpos = pos * 2;
				
				if((pos * 2 +1) < heap.size() && max < heap.get(pos * 2 +1)) {
					max = heap.get(pos * 2+1);
					maxpos = pos * 2+1;
				}
				if(heap.get(pos) > max) {
					break;
				}
				int tmp = heap.get(pos);
				heap.set(pos, max);
				heap.set(maxpos, tmp);
				pos = maxpos;
			}
			
			return value;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int line_num = Integer.parseInt(br.readLine());
		
		MaxHeap maxheap = new MaxHeap();
		for(int i = 0; i < line_num; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				// pop_node
				System.out.println(maxheap.delete());
			}
			else {
				// insert at heap
				maxheap.insert(num);
				
			}
		}
		
	
	}

}
