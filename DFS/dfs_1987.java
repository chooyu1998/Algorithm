import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class DFS_2606{
	int R, C;
	char[][] map;
	int[] alphabet;
	int res = 0;
	int[] dx = {0,0,-1,1};
	int[] dy = {1,-1,0,0};
	DFS_2606(int r, int c){
		R = r;
		C = c;
		map = new char[R][C];
		alphabet = new int[27];
	}
	
	void Fill_Map(char ch,int r, int c) {
		map[r][c] = ch;
	}
	
	void Find_Move(int r, int c,int count) {
		char ch = map[r][c];
		if( alphabet[ch - 'A'] == 1) {
			res = Math.max(res, count);
		}
		else {
			//System.out.println(ch);
			alphabet[ch - 'A'] = 1;
			for(int i = 0; i < 4; i++) {
				int new_r = r + dx[i];
				int new_c = c + dy[i];
				if(-1 < new_r && new_r < R && -1 < new_c && new_c < C) {
					//System.out.println(new_r+":"+new_c);
					Find_Move(new_r, new_c,count + 1);
				}
			}
			alphabet[ch - 'A'] = 0;
		}
		
		
		
		
	}
}

public class dfs_1987 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int R = Integer.parseInt(str.split(" ")[0]);
		int C = Integer.parseInt(str.split(" ")[1]);
		
		DFS_2606 dfs = new DFS_2606(R,C);
		for(int i = 0; i < R; i++) {
			str = br.readLine();
			for(int j = 0; j < C; j++) {
				char ch = str.charAt(j);
				dfs.Fill_Map(ch, i, j);
			}
		}
		
		dfs.Find_Move(0, 0,0);
		System.out.println(dfs.res);
		
	}

}
