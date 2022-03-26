import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class obj_1325{
	int V;
	LinkedList<Integer> adj[];
	int[] computer;
	int res = 0;
	obj_1325(int v){
		V = v+1;
		
		adj = new LinkedList[V];
		computer = new int[V];
		
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	void AddEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void FindHacking(int start, boolean[] visited) {
		visited[start] = true;
		LinkedList<Integer> queue = new LinkedList();
		
		queue.add(start);
		
		while(! queue.isEmpty()) {
			int v = queue.pop();
			for(Integer i : adj[v]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
					computer[start] += 1;
				}
			}
		}
		
	}
}

public class bfs_1325 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int node = Integer.parseInt(str.split(" ")[0]);
		int edge = Integer.parseInt(str.split(" ")[1]);
		
		obj_1325 bfs = new obj_1325(node);
		for(int i = 0; i < edge; i++) {
			str = br.readLine();
			int node_1 = Integer.parseInt(str.split(" ")[0]);
			int node_2 = Integer.parseInt(str.split(" ")[1]);
			
			bfs.AddEdge(node_2, node_1);
		}
		int max = 0;
		for(int i = 1; i < node+1; i++) {
			boolean[] visited = new boolean[node+1];
			bfs.FindHacking(i, visited);			
		}
		
		for(int i = 1; i < node+1; i++) {
			max = Math.max(max, bfs.computer[i]);
		}
		for(int i = 1; i < node+1; i++) {
			if(bfs.computer[i] == max) {
				System.out.print(i+" ");
			}
		}
		
	}

}
