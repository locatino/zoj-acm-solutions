import java.util.Scanner;


public class PointsWithin_4 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int count = 1;
		while(sc.hasNext()){
			int vertexNum = sc.nextInt();
			if(vertexNum == 0)break;
			if(count != 1){
				sb.append('\n');
				System.out.println();
			}
//			sb.append("Problem " + count + ":").append('\n');
			System.out.println("Problem " + count + ":");
			int nodeNum = sc.nextInt();
			
			int[][] vertice = new int[vertexNum][2];
			
			for(int i = 0; i < vertexNum; i++){
				vertice[i][0] = sc.nextInt();
				vertice[i][1] = sc.nextInt();
			}
			int[][] nodes = new int[nodeNum][2];
			for(int i = 0; i < nodeNum; i++){
				nodes[i][0] = sc.nextInt();
				nodes[i][1] = sc.nextInt();
			}
			for(int i = 0; i < nodes.length; i++){
				int[] point = new int[]{nodes[i][0], nodes[i][1]};
				if(insidePolygon(vertice ,point)){
//					sb.append("Within\n");
					System.out.println("Within");
				}else {
//					sb.append("Outside\n");
					System.out.println("Outside");
				}
			}
			count++;
//			System.out.println();
		}
//		System.out.println(sb.toString());
	}

	private static boolean insidePolygon(int[][] vertice, int[] p) {
		//取向左的射线
		int[] p1 = new int[2];
		p1[0] = vertice[0][0];
		p1[1] = vertice[0][1];
		int counter = 0;
		for(int i = 1; i <= vertice.length; i++){
			int[] p2 = new int[2];
			p2[0] = vertice[i % vertice.length][0];
			p2[1] = vertice[i % vertice.length][1];
			
			//先判断水平线情况
			if(p1[1] == p2[1]){
				if(p[1] == p1[1]){
					if(p[0] >= MIN(p1[0], p2[0]) && p[0] <= MAX(p1[0], p2[0])){
						return true;
					}
				}
			}else if(p[1] > MIN(p1[1], p2[1]) && p[1] <= MAX(p1[1], p2[1]) && p[0] >= MIN(p1[0], p2[0])){
				//操你妈 要ac老子还要全改成double
				double x = ((double)p[1] - (double)p1[1]) * ((double)p2[0] - (double)p1[0])/((double)p2[1] - (double)p1[1]) + (double)p1[0];
				if(x == (double)p[0]){
					return true;
				}
				if(x < p[0] && p[1] != MIN(p1[1], p2[1])){
					counter++;
				}
			}
			p1[0] = p2[0];
			p1[1] = p2[1];
		}
//		System.out.println(counter);
		if(counter % 2 == 0){
			return false;
		}else return true;
	}
	public static int MIN(int x, int y){
		return (x < y ? x : y);
	}
	public static int MAX(int x, int y){
		return (x > y ? x : y);
	}
}
/*
3 1
0 0
0 5
5 0
10 2
3 2
4 4
3 1
1 2
1 3
2 2
0
Problem 1:
Outside

Problem 2:
Outside
Within

3 1
3 0
-3 0
0 2
0 0
*/