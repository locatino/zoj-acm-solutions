import java.util.Scanner;


public class StockerbrokerGrapevine {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			int num = sc.nextInt();
			if(num == 0){
				return;
			} else {
				//输入可以看做一张有向有权图，用二维矩阵map保存各点到各点的权值
				//
				int[][] map = new int[num][num];
				for(int i = 0; i < num; i++){
					int points = sc.nextInt();
					for(int j = 0; j < points; j++){
						map[i][sc.nextInt() - 1] = sc.nextInt();
					}
				}
//				print(map);
				//distance保存各个点到各个点的最短距离
				int[][] distance = new int [num][num];
				//每个点算一遍
				for(int i = 0; i < num; i++){
					process(i, map, distance, new int[]{i,-1,-1,-1,-1});
				}
				//上步结束之后distance就完成了！( ⊙ o ⊙ )啊！
				int[] result = new int[num];
				for(int i = 0; i < num; i++){
					boolean disjoint = false;
					int max = 0;
					for(int j = 0; j < num; j++){
						if(distance[i][j] == 0 && i != j){
							disjoint = true;
						}
						if(distance[i][j] > max){
							max = distance[i][j];
						}
					}
					if(!disjoint){
						result[i] = max;
					}else {
						result[i] = -1;
					}
				}
				int min = Integer.MAX_VALUE;
				int index = -1;
				boolean disjoint = true;
				for(int i = 0; i < result.length; i++){
					if(result[i] < min && result[i] != -1){
						min = result[i];
						index = i;
						disjoint = false;
					}
				}
				if(disjoint)
					System.out.println("disjoint");
				else {
					System.out.println((index+1)+" "+result[index]);
				}
			}
		}
	}
	
	public static void process(int pNum, int[][] map , int[][] distance, int[] before){
		loop:
		for(int i = 0; i < map.length; i++){
			if(map[pNum][i] == 0)continue;
				for(int k = 0; k < before.length; k++){
				if(before[k] == i){
					continue loop;
				}
			}
			if(map[pNum][i] != 0){
				if(distance[pNum][i] ==  0 || distance[pNum][i] > map[pNum][i])
					distance[pNum][i] = map[pNum][i];
				for(int j = before.length - 1; j >= 0; j--){
					if(before[j] != -1){
						int sum = distance[before[j]][pNum] + distance[pNum][i];
						if(distance[before[j]][i] == 0 || distance[before[j]][i] > sum){
							distance[before[j]][i] = sum;
						}
//						System.out.println("x: " + before[j] + " y: " + i + " dis: " + distance[before[j]][i]);
					}
				}
			}
			int[] before_copy = copyArray(before);
			for(int n = 0; n < before_copy.length; n++){
				if(before_copy[n] == -1){
					before_copy[n] = i;
					break;
				}
			}
			process(i, map, distance, before_copy);
		}
	}
	public static int[] copyArray(int[] before){
		int[] before_copy = new int[before.length];
		for(int i = 0; i < before.length; i++){
			before_copy[i] = before[i];
		}
		return before_copy;
	}
	public static void print(int[][] map){
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map.length; j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
/*
SAMPLE INPUT

3
2 2 4 3 5
2 1 2 3 6
2 1 2 2 2
5
3 4 4 2 8 5 3
1 5 8
4 1 6 4 10 2 7 5 2
0
2 2 5 1 5
0


SAMPLE OUTPUT

3 2
3 10
*/