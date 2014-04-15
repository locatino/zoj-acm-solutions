import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class KnightMove {
	static KnightMove km = new KnightMove();
	class Node{
		int x;
		int y;
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static int move(List<Node> leaf, List<Node> list, Node target, int depth){
		int x; int y;
		List<Node> next_leaf = new ArrayList<Node>();
		for(Node n : leaf){
			if(n.x == target.x && n.y == target.y)return depth;
			//one
			x = n.x - 1; y = n.y - 2;
			check(x, y, next_leaf, list);
			//two
			x = n.x + 1; y = n.y - 2;
			check(x, y, next_leaf, list);
			//three
			x = n.x + 2; y = n.y - 1;
			check(x, y, next_leaf, list);
			//four
			x = n.x + 2; y = n.y + 1;
			check(x, y, next_leaf, list);
			//five
			x = n.x + 1; y = n.y + 2;
			check(x, y, next_leaf, list);
			//six
			x = n.x - 1; y = n.y + 2;
			check(x, y, next_leaf, list);
			//seven
			x = n.x - 2; y = n.y + 1;
			check(x, y, next_leaf, list);
			//eight
			x = n.x - 2; y = n.y - 1;
			check(x, y, next_leaf, list);

		}
		return move(next_leaf, list, target, depth + 1);
	}
	public static void check(int x, int y, List<Node> next_leaf, List<Node> list){
		if(x >= 0 && y >= 0 && x < 8 && y < 8){
			int flag = 0;
			for(Node i : list){
				if(i.x == x && i.y == y)flag = 1;
			}
			if(flag == 0){
				next_leaf.add(km.new Node(x, y));
				list.add(km.new Node(x, y));
			}
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String start = sc.next();
			String end = sc.next();
			int start_x = (int)start.charAt(0) - 97;
			int start_y = (int)start.charAt(1) - 49;
			int end_x = (int)end.charAt(0) - 97;
			int end_y = (int)end.charAt(1) - 49;
			Node target = km.new Node(end_x, end_y);
			List<Node> leaf = new ArrayList<Node>();
			leaf.add(km.new Node(start_x, start_y));
			List<Node> list = new ArrayList<Node>(leaf);
			System.out.println("To get from "+start+" to "+end+" takes "+move(leaf, list, target, 0)+" knight moves.");
			
		}
		
	}
}
