import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class PalindromNumbers {
	enum Identifier{
		_0(0),_1(1),_2(2),_3(3),_4(4),_5(5),_6(6),_7(7),_8(8),_9(9),_10(10),A(11),B(12),C(13),D(14),E(15),
		UNKOWN(-1);
		public int value;
		private Identifier(int value) {
			this.value = value;
		}
		public int getValue(){return value;}
		
		public static Identifier getId(int i){
			for(Identifier n : Identifier.values()){
				if(n.getValue() == i)
					return n;
			}
			return Identifier.UNKOWN;
		}
	}
	public static List<Integer> checkPalindromNumbers(int n){
		List<Integer> bases = new ArrayList<Integer>();
		for(int i = 2; i <= 16; i++){
			List<Identifier> result = new ArrayList<Identifier>();
			int temp = n;
			int flag = 0;
			while(true){
				int id = temp % i;
//				System.out.println(id);
				result.add(Identifier.getId(id));
				temp = temp / i;
				if(temp == 0)break;
			}
			List<Identifier> rev = new ArrayList<Identifier>(result);
			Collections.reverse(rev);
			for(int j = 0; j < rev.size(); j++){
				if(rev.get(j).getValue() != result.get(j).getValue()){
					flag = 1;
					break;
				}
			}
			if(flag == 0)bases.add(i);
//			System.out.println(result);
		}
		return bases;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n == 0)break;
			List<Integer> bases = checkPalindromNumbers(n);
			if(bases.size() == 0){
				System.out.println("Number "+n+" is not a palindrom");
			}else {
				System.out.print("Number "+n+" is palindrom in basis");
				for(int i : bases){
					System.out.print(" ");
					System.out.print(i);
				}
				System.out.println();
			}
			
		}
		
	}
}
