import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class tree_1927 {
	static ArrayList<Integer> heap;
	static class MinHeap{
		MinHeap(){
			heap = new ArrayList<Integer>();
			heap.add(0);
		}
		
		public void insert(int value) {
			heap.add(value);
			int pos = heap.size() -1;
			
			while(pos > 1 && heap.get(pos) < heap.get(pos/2)) {
				int tmp = heap.get(pos/2);
				heap.set(pos/2, heap.get(pos));
				heap.set(pos, tmp);
				
				pos /= 2;
			}
		}
		public int delete() {
			if (heap.size()-1 < 1) {
				return 0;
			}
			
			int delete = heap.get(1);
			
			heap.set(1, heap.get(heap.size() -1));
			heap.remove(heap.size()-1);
			int pos = 1;
			
			while(pos * 2 < heap.size()) {
				int min = heap.get(pos*2);
				int minpos = pos * 2;
				
				if((pos*2 + 1) < heap.size() -1  && heap.get(pos * 2 + 1) < min){
					min = heap.get(pos * 2 + 1);
					minpos = pos * 2 +1;
				}
				
				if(heap.get(pos) < min) {
					break;
				}
				
				int tmp = heap.get(pos);
				heap.set(pos, min);
				heap.set(minpos, tmp);
				pos = minpos;
			}
			
			return delete;
		}
		
	
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int line_num = Integer.parseInt(br.readLine());
		
		MinHeap minheap = new MinHeap();
		for(int i = 0; i < line_num; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				System.out.println( minheap.delete() );
				
			}else {
				minheap.insert(num);
			}
		}
		
	}

}
