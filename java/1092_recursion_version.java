import java.util.Scanner;
public class Arbitrage {
	public static void main(String[] args){
		int task = 1;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int length = sc.nextInt();
			if(length == 0)return;
			String[] name = new String[length];
			for(int i = 0; i < length; i++){
				name[i] = sc.next();
			}
			int rela = sc.nextInt();
			double[][] map = new double[length][];
			for(int i = 0; i < length; i++){
				map[i] = new double[length];
			}
			for(int i = 0; i < rela; i++){
				String from = sc.next();
				double rate = sc.nextFloat();
				String to = sc.next();
				int x = -1, y = -1;
				for(int j = 0; j < length; j++){
					if(name[j].equals(from)){
						x = j;
					}
					if(name[j].equals(to)){
						y = j;
					}
				}
				map[x][y] = rate;
			}
			boolean flag = false;
			for(int i = 0; i < length; i++){
				for(int j = 0; j < length; j++){
					for(int k = 0; k < length; k++){
						double temp = map[i][j] * map[j][k];
						if(temp > map[i][k]){
							map[i][k] = temp;	
						}
					}	
				}
			}
			for(int i = 0; i < length; i++){
				if(map[i][i] > 1){
					flag = true;
				}
			}
			if(flag){System.out.println("Case "+task+": Yes");}
			else {System.out.println("Case "+task+": No");}
			task++;
		}
	}
}
/*

*/
/***
 * 
3
USDollar
BritishPound
FrenchFranc
3
USDollar 0.5 BritishPound
BritishPound 10.0 FrenchFranc
FrenchFranc 0.21 USDollar

3
USDollar
BritishPound
FrenchFranc
6
USDollar 0.5 BritishPound
USDollar 4.9 FrenchFranc
BritishPound 10.0 FrenchFranc
BritishPound 1.99 USDollar
FrenchFranc 0.09 BritishPound
FrenchFranc 0.19 USDollar

0

Sample Output

Case 1: Yes
Case 2: No

 */