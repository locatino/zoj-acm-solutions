import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int result = 0;
		while(sc.hasNext()){
			double temp = sc.nextDouble();
			if(temp == 0)return;
			else {
				result = calculate(temp);
				System.out.println(result+" card(s)");
			}
		}
	}
	public static int calculate(double temp){
		int result = 1;
//		System.out.println(temp);
		double now = solveTheFunction(result);
//		System.out.println(now);
			while(temp > now){
				result++;
				now += solveTheFunction(result);
			}
		return result;
		
	}
	
	public static double solveTheFunction(int n){
		double result = 1.00/(n+1);
		return result;
	}
}