import java.util.Scanner;
import java.util.Stack;


public class CodeTheTree {
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String tmp = sc.nextLine();
			char[] array = tmp.toCharArray();
			map = new int[50][50];
			int index = 0;
			int count = 0;
			Stack<Integer> stack = new Stack<Integer>();
			while(index < array.length){
				if(array[index] == ')'){
					stack.pop();
				}else if(array[index] != '(' && array[index] != ' '){
					StringBuilder sb = new StringBuilder();
					sb.append(array[index]);
					if(array[index+1] != '(' && array[index + 1] != ')' && array[index + 1] != ' '){
						sb.append(array[index + 1]);
						index++;
					}
					int number = Integer.parseInt(sb.toString()) - 1;
					if(stack.size() > 0){
						map[stack.lastElement()][number] = 1;
						map[number][stack.lastElement()] = 1;
					}
					stack.add(number);
					count++;
				}
				index++;
			}
//			for(int i = 0; i < map.length; i++){
//				for(int j = 0; j < map.length; j++){
//					System.out.print(map[i][j]);
//					System.out.print(" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			if(count == 1){System.out.println();continue;}
			StringBuilder sb = new StringBuilder();
			int i = 0;
			for(;i < map.length;){
				int edge = 0;
				int tmp_j = 0;
				for(int j = 0; j < map.length; j++){
					if(map[i][j] == 1){
						edge++;
						tmp_j = j;
					}
				}
				if(edge == 1){
					sb.append(tmp_j + 1).append(' ');
					map[i][tmp_j] = 0;
					map[tmp_j][i] = 0;
					i = 0;
				}else i++;
			}
		//	sb.append(count);
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb);
		}
	}
}
