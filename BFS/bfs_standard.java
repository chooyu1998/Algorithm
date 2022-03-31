import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

//solution for https://www.acmicpc.net/problem/1260 

class BFS_st{
	int V;
	LinkedList<Integer> adj[];
	
	BFS_st(int v){
		V = v+1;
		adj = new LinkedList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	void AddEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	void FindPath(int start) {
		boolean[] visited = new boolean[V];
		visited[start] = true;
		System.out.print(start+" ");
		LinkedList<Integer> queue = adj[start];
		Collections.sort(queue);
		while (! queue.isEmpty()) {
			int v = queue.poll();
			if(!visited[v]) {
				System.out.print(v+" ");
				LinkedList<Integer> tmp_queue = adj[v];
				Collections.sort(tmp_queue);
				for(Integer i : tmp_queue) {
					queue.add(i);
				}
			}
			
			visited[v] = true;
				
		}
		
	}

}

class DFS{
	int V;
	LinkedList<Integer> adj[];
	boolean[] visited;
	DFS(int v){
		V = v+1;
		adj = new LinkedList[V];
		visited = new boolean[V];
		
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList();
		}
	}
	void AddEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	void FindPath(int start) {
		if (visited[start]) return;
		else {
			visited[start] = true;
			System.out.print(start+" ");
			LinkedList<Integer> queue = adj[start];
			Collections.sort(queue);
			
			for(Integer i : queue) {
				FindPath(i);
			}
		}
		
		
	}
}

public class bfs_standard {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int node = Integer.parseInt(str.split(" ")[0]);
		int edge = Integer.parseInt(str.split(" ")[1]);
		int start = Integer.parseInt(str.split(" ")[2]);
		
		BFS_st bfs = new BFS_st(node);
		DFS dfs = new DFS(node);
		for(int i = 0; i < edge; i++) {
			str = br.readLine();
			int node_1 = Integer.parseInt(str.split(" ")[0]);
			int node_2 = Integer.parseInt(str.split(" ")[1]);
			
			bfs.AddEdge(node_1, node_2);
			dfs.AddEdge(node_1, node_2);
		}
		
		dfs.FindPath(start);
		System.out.println();
		bfs.FindPath(start);
		
	}

	
}
