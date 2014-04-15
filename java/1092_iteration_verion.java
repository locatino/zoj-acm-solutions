import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Arbitrage_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int task = 1;
		while(true){
			String l = null;
			while(l == null || l.equals("")){
				l = reader.readLine();
			}
			int length = Integer.parseInt(l);
			if(length == 0)return;
			String[] name = new String[length];
			for(int i = 0; i < length; i++){
				name[i] = reader.readLine();
			}
			double[][] map = new double[length][];
			for(int i = 0; i < length; i++){
				map[i] = new double[length];
			}
			int rela = Integer.parseInt(reader.readLine());
			for(int i = 0; i < rela; i++){
				String s = reader.readLine();
				String[] re = s.split(" ");
				String from = re[0];
				double rate = Double.parseDouble(re[1]);
				String to = re[2];
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
