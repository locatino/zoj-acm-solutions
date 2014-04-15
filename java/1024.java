import java.util.Scanner;


public class CalenderGame {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		while (count-- > 0){
			int year = sc.nextInt();
			int mon = sc.nextInt();
			int day = sc.nextInt();
			if(mon == 9 && day == 30)System.out.println("YES");
			else if(mon == 11 && day == 30)System.out.println("YES");
			else if((mon + day) % 2 == 0)System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
/**
日期的奇偶性
**/