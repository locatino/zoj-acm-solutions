import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class MonkeyAndBanana_5 {
	class Face{
		int x;
		int y;
		int z;
		int max_height = -1;
		
		public Face(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public boolean big(Face f){
			if((x > f.x && y > f.y) || (x > f.y && y > f.x)){
				return true;
			}
			return false;
		}
	}
	public static int recursive(List<Face> list, Face f){
		int max = f.z;
		for(Face i : list){
			if(f.big(i)){
				if(i.max_height == -1){
					int add =  recursive(list, i);
					if(max < f.z + add){
						max = f.z + add;
					}
				}else {
					if(max < f.z + i.max_height){
						max = f.z + i.max_height;
					}
				}
			}
		}
		f.max_height = max;
		return f.max_height;
	}
	public static void main(String[] args){
		MonkeyAndBanana_5 mab = new MonkeyAndBanana_5();
		Scanner sc = new Scanner(System.in);
		int cases = 0;
		while(true){
			cases++;
			int cubeNum = sc.nextInt();
			if(cubeNum == 0)break;
			List<Face> list = new ArrayList<Face>();
			for(int i = 0; i < cubeNum; i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				int z = sc.nextInt();
				if(x == y && x == z ){
					list.add(mab.new Face(x,y,z));
				}else if( x == y || x == z || y == z){
					if(x == y){
						list.add(mab.new Face(x,y,z));
						list.add(mab.new Face(x,z,y));
					}
					if(x == z){
						list.add(mab.new Face(x,y,z));
						list.add(mab.new Face(x,z,y));
					}
					if(y == z){
						list.add(mab.new Face(x,y,z));
						list.add(mab.new Face(y,z,x));
					}
				}else {
					list.add(mab.new Face(x,y,z));
					list.add(mab.new Face(y,z,x));
					list.add(mab.new Face(x,z,y));					
				}
			}
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).max_height == -1){
					recursive(list, list.get(i));
				}
			}
			int max = 0;
			for(Face i : list){
				if(i.max_height > max)max = i.max_height;
			}
			System.out.println("Case "+cases+": maximum height = "+max);
		}
	}
}
