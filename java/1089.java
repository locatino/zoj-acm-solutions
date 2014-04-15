import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Lotto {
	static int flag = 0;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int count = sc.nextInt();
			if(count == 0)return;
			if(flag == 1)System.out.println();
			flag = 0;
			int[] numbers = new int[count];
			for(int i = 0; i < count; i++){
				numbers[i] = sc.nextInt();
			}
			List<Integer> result = new ArrayList<Integer>();
			for(int i = 0; i < (1<<count); i++){
				int ones = 0;
				for(char k : Integer.toBinaryString(i).toCharArray()){
					if(k == '1')ones++;
				}
				if(ones == 6){result.add(i);}
			}
//			System.out.println(result);
			Collections.reverse(result);
			for(int i : result){
				StringBuilder sb = new StringBuilder();
				char [] array = Integer.toBinaryString(i).toCharArray();
				int zeros = count - array.length;
				if(zeros > 0){
					char[] new_array = new char[count];
					for(int n = 0; n < zeros; n++){
						new_array[n] = 0;
					}
					for(int t = 0; t < array.length; t++){
						new_array[t + zeros] = array[t];
					}
					array = new_array;
				}
				for(int idx = 0; idx < count; idx++){
					if(array[idx] == '1'){
						sb.append(numbers[idx]);
						sb.append(" ");
					}
				}
				sb.deleteCharAt(sb.length() - 1);
				System.out.println(sb);
			}
			flag = 1;
		}
	}
}
/**
 * 
Sample Input

7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0

Sample Output

1 2 3 4 5 6
1 2 3 4 5 7
1 2 3 4 6 7
1 2 3 5 6 7
1 2 4 5 6 7
1 3 4 5 6 7
2 3 4 5 6 7

1 2 3 5 8 13
1 2 3 5 8 21
1 2 3 5 8 34
1 2 3 5 13 21
1 2 3 5 13 34
1 2 3 5 21 34
1 2 3 8 13 21
1 2 3 8 13 34
1 2 3 8 21 34
1 2 3 13 21 34
1 2 5 8 13 21
1 2 5 8 13 34
1 2 5 8 21 34
1 2 5 13 21 34
1 2 8 13 21 34
1 3 5 8 13 21
1 3 5 8 13 34
1 3 5 8 21 34
1 3 5 13 21 34
1 3 8 13 21 34
1 5 8 13 21 34
2 3 5 8 13 21
2 3 5 8 13 34
2 3 5 8 21 34
2 3 5 13 21 34
2 3 8 13 21 34
2 5 8 13 21 34
3 5 8 13 21 34

















For each test case,print all possible games, each game on one line. 
The numbers of each game have to be sorted in ascending order and separated from each other by exactly one space. 
The games themselves have to be sorted lexicographically, that means sorted by the lowest number first, 
then by the second lowest and so on, as demonstrated in the sample output below. The test cases have to be separated
from each other by exactly one blank line. Do not put a blank line after the last test case. 
*/

