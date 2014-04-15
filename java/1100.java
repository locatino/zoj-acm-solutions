import java.util.Scanner;


public class Main {
	static int w;
	static int l;
	static int count = 0;
	static long[][] dp;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			w = sc.nextInt();
			l = sc.nextInt();
			if(w == 0 && l == 0){return;}
			if((w * l) % 2 == 1){System.out.println(0);continue;}
			if(w > l){w ^= l; l ^= w; w^=l;}
			if(w == 1){System.out.println(1);continue;}
			dp = new long[12][2049];
			for(int i = 0; i < 12; i++){
				for(int j = 0; j < 2049; j++){
					dp[i][j] = -1;
				}
			}
			for(int i = 0; i < 2049; i++){
				dp[w - 1][i] = 1;
			}
			process((1<<l) - 1, 0);
			System.out.println(dp[0][(1<<l) - 1]);
		}
	}
	public static long process(int state, int x){
		if(x + 1 > w){return 1;}
		for(int i = 0; i < (1<<l); i++){
			if(!conflict(state, i, x)){
				if(dp[x + 1][i] == -1){
					dp[x + 1][i] = 0;
					dp[x + 1][i] = process(i, x + 1);
				}
				if(dp[x][state] == -1)dp[x][state] = 0;
				dp[x][state] += dp[x + 1][i];
			}
		}
		return dp[x][state];
	}
	public static boolean conflict(int prev, int next, int x){
		if(x + 2 == w){
			char[] last = Integer.toBinaryString(next).toCharArray();
			for(int i = 0; i < last.length - 1; i++){
				if(last[i] == '1'){
					if(last[i + 1] != '1')return true;
					else i++;
				}
			}
		}
		for(int i = 0; i < l; i++){
			int up = 1;
			int down = 1;
			if((prev & (1<<(l - i - 1))) == 0){
				up = 0;
			}
			if((next & (1<<(l - i - 1))) == 0){
				down = 0;
			}
			if(up == 1){
				if(down != 0){
					if((prev & (1<<(l - i - 2))) == 0){
						return true;
					}
					if((next & (1<<(l - i - 2))) == 0){
						return true;
					}
					i++;
				}
			}
			if(up == 0){
				if(down == 0){
					return true;
				}
			}
		}
		return false;
	}
}
