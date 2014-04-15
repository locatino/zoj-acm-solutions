import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class IllusiveChase {
	public static final char U = 'U';
	public static final char D = 'D';
	public static final char L = 'L';
	public static final char R = 'R';
	
	public static int cells = 0;
	public static int flag = 0;
	class Operation {
		int lower;
		int upper;
		int operation;
		Operation(){}
		Operation(int lower, int upper, int operation){
			this.lower = lower;
			this.upper = upper;
			this.operation = operation;
		}
	}
	public static int findCells(int[][] field, List<Operation> operation){
		int column = field.length;
		int row = field[0].length;
		int result = 0;
		for(int i = 0; i < column; i++){
			for(int j = 0; j < row; j++){
				if(field[i][j] == 1)continue;
				else {
					recursive(field, operation, 0, new int[] {i,j});
					if(flag == 1){
						cells++;
						flag = 0;
					}
				}
			}
		}
		return result;
	}
	
	public static void recursive(int[][] a, List<Operation> operation, int start, int[] index){
		if(flag == 1){
			return;
		}
		if(start == operation.size()){
			flag = 1;
			return;
		}
		int i = index[0];
		int j = index[1];
		Operation op = operation.get(start);
		for(int steps = op.lower; steps <= op.upper; steps++){
			switch(op.operation){
			case U:
			{
				if(i - steps < 0)break;
				boolean obstacle = false;
				for(int temp = 1; temp <= steps; temp++){
					if(a[i - temp][j] == 1)obstacle = true;
				}
				if(obstacle)break;
				recursive(a, operation, start + 1, new int[] {i - steps, j});
			}
				break;
			case D:
			{
				if(i + steps  >= a.length)break;
				boolean obstacle = false;
				for(int temp = 1; temp <= steps; temp++){
					if(a[i + temp][j] == 1)obstacle = true;
				}
				if(obstacle)break;
				recursive(a, operation, start + 1, new int[] {i + steps, j});
			}
				break;
			case L:
			{
				if(j - steps < 0)break;
				boolean obstacle = false;
				for(int temp = 1; temp <= steps; temp++){
					if(a[i][j - temp] == 1)obstacle = true;
				}
				if(obstacle)break;
				recursive(a, operation, start + 1, new int[] {i, j - steps});
			}
				break;
			case R:
			{
				if(j + steps >= a[0].length)break;
				boolean obstacle = false;
				for(int temp = 1; temp <= steps; temp++){
					if(a[i][j + temp] == 1)obstacle = true;
				}
				if(obstacle)break;
				recursive(a, operation, start + 1, new int[] {i, j + steps});
			}
				break;
			}
		}		
	}
	public static void main(String[] args){
//		int a[][] = new int[6][6];
//		for(int i = 0; i < a.length; i++){
//			for(int j = 0; i < a[i].length; i++){
//				a[i][j] = 
//			}
//		}
//		int a[][] = {{0,0,0,0,0,0},
//					 {0,0,0,1,1,0},
//					 {0,1,0,0,0,0},
//					 {0,0,0,1,0,0},
//					 {0,0,0,1,0,1},
//					 {0,0,0,0,0,1},};
//		List<Operation> op = new ArrayList<Operation>();
		IllusiveChase b = new IllusiveChase();
//		op.add(b.new Operation(1,2,R));
//		op.add(b.new Operation(1,2,D));
//		op.add(b.new Operation(1,1,R));
//		findCells(a, op);
//		System.out.println(cells);
		
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int i = 0; i < cases; i++){
			int column = sc.nextInt();
			int row = sc.nextInt();
			int[][] in = new int[column][];
			for(int j = 0; j < column; j++){
				in[j] = new int[row];
			}
			for(int m = 0; m < column; m++){
				for(int n = 0; n < row; n++){
					in[m][n] = sc.nextInt();
				}
			}
			List<Operation> opera = new ArrayList<Operation>();
			while(true){
			int lower = sc.nextInt();
			int upper = sc.nextInt();
			if(lower == 0 && upper == 0)break;
			char dir = sc.next().charAt(0);
			opera.add(b.new Operation(lower, upper, dir));
			}
			findCells(in, opera);
			System.out.println(cells);
			cells = 0;
		}
	}
}
