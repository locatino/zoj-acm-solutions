import java.util.Scanner;


public class ChannelAllocation_2 {
	static int[] color;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int nodes = sc.nextInt();
			if(nodes == 0)return;
			int[][] map = new int[nodes][];
			for(int i = 0; i < nodes; i++){
				map[i] = new int[nodes];
			}
			boolean one = true;
			for(int i = 0; i < nodes; i++){
				String temp = sc.next();
				char[] re = temp.toCharArray();
				if(re.length > 2){
					for(int idx = 2; idx < re.length; idx++){
						int x = i;
						int y = re[idx] - 'A';
						map[x][y] = -1;
						one = false;
					}
				}
			}
			if(one){
				System.out.println("1 channel needed.");
				continue;
			}
			color = new int[nodes];
			
			
//			for(int i = 0; i < nodes; i++){
//				for(int j = 0; j < nodes; j++){
//					System.out.print(map[i][j]);
//					System.out.print(" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			if(dfs(map,2)){
				System.out.println("2 channels needed.");
				continue;
			}
//			System.out.println(dfs(map, 2));
			color = new int[nodes];
			if(dfs(map,3)){
				System.out.println("3 channels needed.");
				continue;
			}
			System.out.println("4 channels needed.");
//			System.out.println(dfs(map, 3));
		}
	}
	
	public static boolean dfs(final int[][] map, int cl) {
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map.length; j++){
			//	if(i < j){
					if(color[i] == 0){
						for(int c = 1; c <= cl; c++){
							color[i] = c;
							for(int k = 0; k < map.length; k++){
								if(map[i][k] == -1){
									if(color[k] == c){
										color[i] = 0;
										break;
									}
								}
							}
							if(color[i] != 0)break;
						}
						if(color[i] == 0){return false;}
					}
			//	}
			}
		}
//		for (int i = 0; i < map.length; i++) {
//			System.out.print(color[i]);
//		}
//		System.out.println();
		return true;
	}
}
/*
SAMPLE INPUT

2
A:
B:
4
A:BC
B:ACD
C:ABD
D:BC
4
A:BCD
B:ACD
C:ABD
D:ABC
0


SAMPLE OUTPUT

1 channel needed.
3 channels needed.
4 channels needed. 
 */
