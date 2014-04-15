import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CrackingTheCode_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] key1 = new char[]{'1'};
		char[] key2 = new char[]{'1','2'};
		char[] key3 = new char[]{'1','2','3'};
		char[] key4 = new char[]{'1','2','3','4','5','6','7','8','9','0'};
		for(int i = 0; i < 30000; i++){
			System.out.print((char)((char)Integer.parseInt(br.readLine()) ^ key1[i % key1.length]));
		}
		for(int i = 0; i < 30000; i++){
			System.out.print((char)((char)Integer.parseInt(br.readLine()) ^ key2[i % key2.length]));
		}
		for(int i = 0; i < 30000; i++){
			System.out.print((char)((char)Integer.parseInt(br.readLine()) ^ key3[i % key3.length]));
		}
		for(int i = 0; i < 30000; i++){
			System.out.print((char)((char)Integer.parseInt(br.readLine()) ^ key4[i % key4.length]));
		}
	}
}
