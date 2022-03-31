import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;




public class tree_1991 {
	static class Node{
		char data;
		Node Left, Right;
		
		public Node(char data) {
			this.data = data;
		}
	}
	
	static class Tree{
		Node root;
		
		public void AddNode(char data, char left, char right) {
			if(root == null) {
				root = new Node(data);
				if(left != '.') {
					root.Left = new Node(left);
				}
				if(right != '.') {
					root.Right = new Node(right);
				}
			}else {
				Search(root, data, left, right);
			}
		}
		
		public void Search(Node root, char data, char left, char right) {
			if(root == null) {
				return;
			}
			else if(root.data == data) {
				if(left != '.') {
					root.Left = new Node(left);
				}
				if(right != '.') {
					root.Right = new Node(right);
				}
			}else {
				Search(root.Left, data, left, right);
				Search(root.Right, data, left, right);
			}
		}
		
		public void PreOrder(Node root) {
			System.out.print(root.data);
			if(root.Left != null) PreOrder(root.Left);
			if(root.Right != null) PreOrder(root.Right);
		}
		public void InOrder(Node root) {
			if(root.Left != null) InOrder(root.Left);
			System.out.print(root.data);
			if(root.Right != null) InOrder(root.Right);
		}
		public void PostOrder(Node root) {
			if(root.Left != null) PostOrder(root.Left);
			if(root.Right != null) PostOrder(root.Right);
			System.out.print(root.data);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int node_num = Integer.parseInt(br.readLine());
		
		Tree tree = new Tree();
		
		for(int i = 0; i < node_num; i++) {
			char[] data;
			data = br.readLine().replaceAll(" ", "").toCharArray();
			
			tree.AddNode(data[0], data[1], data[2]);
			
		}
		
		tree.PreOrder(tree.root);
		System.out.println();
		tree.InOrder(tree.root);
		System.out.println();
		tree.PostOrder(tree.root);
		
		
	}

	
}
