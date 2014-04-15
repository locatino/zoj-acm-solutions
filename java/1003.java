import java.util.Scanner;



public class Main {
	static boolean flag_big;
	static boolean flag_small;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int big = sc.nextInt();
			int small = sc.nextInt();
			flag_big = false;
			flag_small = false;
			if(big < small){
				int temp = big;
				big = small;
				small = temp;
			}
			dfs(big, small ,2);
			int result = -1;
			if(flag_big && flag_small){
				result = big;
			}else if(!flag_small)result = big;
			else result = small;
			System.out.println(result);
			
		}
	}
	static void dfs(int big, int small, int n){
		if(small == 1){
			flag_small = true;
			if(big == 1)flag_big = true;
		}
		if(n > 100 || (flag_big && flag_small))return;
		
		if(big % n == 0)dfs(big / n, small, n+1);
		if(small % n == 0)dfs(big, small / n, n+1);
		dfs(big , small , n+1);
	}
}