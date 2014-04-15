import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public class Node {
		int x, y;

		public Node() {
		}

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public String toString(){
			return "(x="+x+", y="+y+")";
		}
	}
	
	public class comparator implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			if(o1.x < o2.x){
				return -1;
			}else if(o1.x > o2.x){
				return 1;
			}else
			return 0;
		}
	}
	public static void main(String[] args) {
		// 处理输入
		Main main = new Main();
		List<Integer> resultList = new ArrayList<Integer>();
		int result = 0;
		Scanner sc = new Scanner(System.in);
		int t = 0;
		int nodeNumber = 0;
		if (sc.hasNext()) {
			t = sc.nextInt();
		}
		while (t > 0) {
			List<Node> nodeList = new ArrayList<Node>();
			nodeNumber = sc.nextInt();
			for (; nodeNumber > 0; nodeNumber--) {
				Node node = main.new Node(sc.nextInt(), sc.nextInt());
				nodeList.add(node);
			}
		// 计算
			Collections.sort(nodeList, main.new comparator());
			result = getSortedSeq(nodeList);
			resultList.add(result);
//			System.out.println(result);
//			System.out.println(nodeList);
//			System.out.println(nodeList);
			t--;
		}
		// 输出
		for (Integer i : resultList) {
			System.out.println(i);
		}
	}

	private static int getSortedSeq(List<Node> nodeList) {
		int result = 1;
		int temp = nodeList.get(0).y;
		nodeList.remove(0);
		for(Iterator<Node> i = nodeList.iterator();i.hasNext();){
			Node o = i.next();
			if(o.y >= temp){
				temp = o.y;
				i.remove();
			}
		}
		if(!nodeList.isEmpty()){
			result = getSortedSeq(nodeList)+1;
		}
		return result;
	}
}


/**
 * 
3
5
4 9 5 2 2 1 3 5 1 4
3
2 2 1 1 2 2
3
1 3 2 2 3 1
 */

