import java.math.BigDecimal;
import java.util.Scanner;


public class OctalFratcions {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String number = sc.next();
			char[] digits = number.toCharArray();
			BigDecimal sum = new BigDecimal(0.0);
			for(int i = 2; i < digits.length; i++){
				int digit = digits[i] - 48;
				BigDecimal bg = new BigDecimal(digit);
				BigDecimal divisor = new BigDecimal(Math.pow(8, i - 1));
				sum = sum.add(bg.divide(divisor));
			}
			System.out.println(number + " [8] = " + sum + " [10]");
		}
	}
}
