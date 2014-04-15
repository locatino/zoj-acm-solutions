import java.util.Scanner;


public class GeneAssembly {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			int num = sc.nextInt();
			if(num == 0){
				return;
			}else {
				int[][] input = new int[num][2];
				int[][] backup = new int[num][2];
				for(int i = 0; i < num; i++){
					input[i][0] = sc.nextInt();
					input[i][1] = sc.nextInt();
					backup[i][0] = input[i][0];
					backup[i][1] = input[i][1];
					
				}
				for(int j = 0; j < num; j++){
					for(int i = 0; i < num - 1; i++){
						if(input[i][1] > input[i + 1][1]){
							int tmp_0 = input[i][0];
							int tmp_1 = input[i][1];
							input[i][0] = input[i + 1][0];
							input[i][1] = input[i + 1][1];
							input[i + 1][0] = tmp_0;
							input[i + 1][1] = tmp_1;
						}
					}
				}
//				for(int i = 0; i < num; i++){
//					System.out.println(input[i][0]+" "+input[i][1]);
//				}
				for(int i = 0 ; i < num; i++){
					if(input[0][0] == backup[i][0] && input[0][1] == backup[i][1]){
						System.out.print(i + 1);
					}
				}
//				System.out.println("===============================");
				int end = input[0][1];
//				System.out.println(input[0][0]+" "+input[0][1]);
				for(int i = 1; i < num; i++){
					if(input[i][0] >= end){
//						System.out.println(input[i][0]+" "+input[i][1]);
						for(int k = 0 ; k < num; k++){
							if(input[i][0] == backup[k][0] && input[i][1] == backup[k][1]){
								System.out.print(" " + (k + 1));
							}
						}
						end = input[i][1];
					}
				}
			}
			System.out.println();
		}
	}
}
/*
Sample Input

6
340 500
220 470
100 300
880 943
525 556
612 776
3
705 773
124 337
453 665
0

Sample Output

3 1 5 6 4
2 3 1
*/