import java.text.DecimalFormat;
import java.util.Scanner;


public class CircumferenceOfCircle {
	public static final double pi = 3.141592653589793;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			double x1 = sc.nextDouble();
			double y1 = sc.nextDouble();
			double x2 = sc.nextDouble();
			double y2 = sc.nextDouble();
			double x3 = sc.nextDouble();
			double y3 = sc.nextDouble();
			double a = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
			double b = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
			double c = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
			DecimalFormat df = new DecimalFormat("#.00");
		    System.out.println(df.format(2*pi*a*b*c/(Math.sqrt((a+b+c)*(a+b-c)*(b+c-a)*(a+c-b)))));
		}
	}
}
//2*pi*a*b*c/(sqrt((a+b+c)*(a+b-c)*(b+c-a)*(a+c-b)))
/**
Sample Input

0.0 -0.5 0.5 0.0 0.0 0.5
0.0 0.0 0.0 1.0 1.0 1.0
5.0 5.0 5.0 7.0 4.0 6.0
0.0 0.0 -1.0 7.0 7.0 7.0
50.0 50.0 50.0 70.0 40.0 60.0
0.0 0.0 10.0 0.0 20.0 1.0
0.0 -500000.0 500000.0 0.0 0.0 500000.0

Sample Output

3.14
4.44
6.28
31.42
62.83
632.24
3141592.65
*/