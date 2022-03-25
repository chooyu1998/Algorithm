import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class BFS {
	int V;
	LinkedList<Integer> adj[];
	int res = -1;
	
	BFS(int v){
		V = v;
		adj = new LinkedList[v+1];
	
		for(int i = 0; i <= v; ++i) {
			adj[i] = new LinkedList();
		}
	
	}
	
	void addEdge(int v, int w) {
		adj[w].add(v);
		adj[v].add(w);		
	}
	
	void FindPath(int node_1, int node_2) {
		boolean visited[] = new boolean[V+1];
		visited[node_1] = true;
		int[] dist = new int[V+1];
		LinkedList<Integer> node_list = adj[node_1];
		
		while(! node_list.isEmpty()) {
			
			int v = node_list.poll();
			visited[v] = true;
			for(int i = 0; i < adj[v].size(); i++) {
				if (!visited[adj[v].get(i)]) {
					node_list.add(adj[v].get(i));
					dist[adj[v].get(i)] += dist[v] + 1;
				}
			}
		}
		if (dist[node_2] != 0) {
			this.res = dist[node_2] + 1;
		}
	}
}

public class bfs_2644{
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		int node = Integer.parseInt(br.readLine());
		
		str = br.readLine();
		int x= Integer.parseInt(str.split(" ")[0]);
		int y = Integer.parseInt(str.split(" ")[1]);
		
		int edge = Integer.parseInt(br.readLine());
		
		BFS dfs = new BFS(node);
		
		for(int i = 0; i < edge; i++) {
			str = br.readLine();
			int node_1 = Integer.parseInt(str.split(" ")[0]);
			int node_2 = Integer.parseInt(str.split(" ")[1]);
			
			dfs.addEdge(node_1, node_2);
		}
		
		
		dfs.FindPath(x,y);
		System.out.println(dfs.res);
	}
	
	
}
