import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while(sc.hasNext()){
			while(count < 1){
				int a = sc.nextInt();
				int b = sc.nextInt();
				int n = sc.nextInt();
				calculate(a,b,n);
				count++;
			}
			count = 0;
		}
	}
	public static void calculate(int a, int b, int n){
		int leftInA = 0;
		int leftInB = 0;
		System.out.println("fill B");
		leftInB = b;
		leftInA = calculateLeftInA(a,n,leftInB);
		while(n != leftInA&& n != a){
			System.out.println("fill B");
			leftInB = b + leftInA;
			while(n != leftInB && leftInB >= a){
				leftInB = calculateLeftInB(a, leftInB, n);
			}
			if(n == leftInB)break;
			leftInA = (leftInA + b)%a;
			System.out.println("pour B A");
		}
		System.out.println("success");
	//	return null;
	}
	public static int calculateLeftInA(int a, int n, int leftInB){
		if(n == a){
			System.out.println("pour B A");
			return leftInB%a;
		}
		while(leftInB/a != 0){
			leftInB = leftInB - a;
			System.out.println("pour B A");
			System.out.println("empty A");	
			System.out.println("pour B A");	
		}
		return leftInB%a;
	}
	public static int calculateLeftInB(int a, int leftInB, int n){		
		leftInB = leftInB - a;
		System.out.println("pour B A");
		if(leftInB != n)
		System.out.println("empty A");
		return (leftInB);
	}
}
