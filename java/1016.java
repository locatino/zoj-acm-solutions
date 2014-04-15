import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Parencodings {
	public static void parencoding(List<Integer> p){
		char[] result = new char[2 * p.size()];
		int fence = 0;
		int pre = 0;
		for(int i : p){
			for(int m = 0; m < i - pre; m++){
				result[fence] = '(';
				fence++;
			}
			pre = i;
			result[fence] = ')';
			fence++;
		}
		List<Integer> w = new ArrayList<Integer>();
		for(int i = 0; i < result.length; i++){
			int wCount = 0;
			int count = 0;
			if(result[i] == ')'){
				int temp = i - 1;
				while(temp >= 0){
					if(result[temp] == ')'){
						count++;
					}else if(result[temp] == '('){
						wCount++;
						if(count == 0){
							break;
						}else count--;
					}
					temp--;
				}
				w.add(wCount);
			}
		}
//		System.out.println(new String(result));
		StringBuilder sb = new StringBuilder();
		for(int i : w){
			sb.append(i).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int i = 0; i < cases; i++){
			int half_length = sc.nextInt();
			List<Integer> p = new ArrayList<Integer>();
			for(int j = 0; j < half_length; j++){
				p.add(sc.nextInt());
			}
			parencoding(p);
		}
	}
}




/***
Sample Input

2
6
4 5 6 6 6 6
9
4 6 6 6 6 8 9 9 9


Sample Output

1 1 1 4 5 6
1 1 2 4 5 1 1 3 9
*/