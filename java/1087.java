import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CrackingTheCode_3 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int n = 0; n < 4; n++){
			char[] ch = new char[30000];
			for(int i = 0; i < 30000; i++){
				ch[i] = (char)Integer.parseInt(br.readLine());
			}
			int[] all = new int[30];
			char[][] key = new char[30][];
			for(int l = 1; l <= 30; l++){
				int[][] times = new int[128][l];
				int[] max = new int[l];
				int[] max_c = new int[l];
				
				for(int i = 0; i < 10000; i++){
					times[ch[i]][i % l]++;
				}

				for(int i = 0; i < l; i++){
						for(int j = 0; j < 128; j++){
						if(times[j][i] > max[i]){
							max[i] = times[j][i];
							max_c[i] = j;
						}
					}
				}
				int sum = 0;
				key[l - 1] = new char[l];
				for(int i = 0; i < l; i++){
					sum += max[i];
					key[l - 1][i] = (char)(max_c[i] ^ ' ');
				}
				all[l - 1] = sum;
			}
			int max = 0;
			int max_i = 0;
			for(int i = 0; i < 30; i++){
				if(all[i] > max){
					max = all[i];
					max_i = i;
				}
			}
			char[] real_key = key[max_i];
			for(int i = 0; i < 30000; i++){
				System.out.print((char)(ch[i] ^ real_key[i % real_key.length]));
			}
		}
	}
}
