import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count = 0;
		float result = 0;
		while(count < 12){
			result += sc.nextFloat();
			count++;
		}
		result =result/12;
		System.out.printf("$%.2f\n", result);
	}
}
