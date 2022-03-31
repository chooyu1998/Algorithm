import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class obj_2606{
	int V;
	LinkedList<Integer> adj[];
	boolean[] visited;
	int res = -1;
	obj_2606 (int v){
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
	void Find_Virus(int start) {
		if(visited[start]) return;
		else {
			visited[start] = true;
			res += 1;
			LinkedList<Integer> stack = adj[start];
			
			for(Integer i : stack) {
				Find_Virus(i);
			}
			
			
		}
		
	}
}

public class dfs_2606 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		int node = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		
		obj_2606 dfs = new obj_2606(node);
		for(int i = 0; i < edge; i++) {
			str = br.readLine();
			int node_1 = Integer.parseInt(str.split(" ")[0]);
			int node_2 = Integer.parseInt(str.split(" ")[1]);
			
			dfs.AddEdge(node_1, node_2);
		}
		
		
		dfs.Find_Virus(1);
		System.out.println(dfs.res);
	}

}
