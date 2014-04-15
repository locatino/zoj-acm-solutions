import java.util.Scanner;


public class Main {
	static int EMPTY = 2;
	static int WALL = 1;
	static int HOUSE = 0;

	static int empty_count = 0;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			if(n == 0)return;
			int[] map = new int[n * n];
			int count = 0;
			for(int i = 0; i < n; i++){
				String line = sc.next();
				char[] temp = line.toCharArray();
				for(int j = 0; j < temp.length; j++){
					if(temp[j] == '.'){
						map[j + i * n] = 0;
						count++;
					}
					if(temp[j] == 'X')map[j + i * n] = 1;
				}
			}
			empty_count = 0;
			dfs(map, 0, n, count);
			System.out.println(empty_count);
		}
	}
	
	static void dfs(final int[] map , int index, int n , int count){
		if(count <= 0)return;
		if(check(map, n)){
			if(empty_count < count)
				empty_count = count;
		}
		if(index >= map.length){
			return;
		}
		int[] map_copy = mapCopy(map);
		dfs(map, index + 1, n, count);
		if(map_copy[index] == HOUSE){
			map_copy[index] = EMPTY;
			dfs(map_copy, index + 1, n, count - 1);
		}
	}
	static int[] mapCopy(final int[] map){
		int[] map_copy = new int[map.length];
		for(int i = 0; i < map.length; i++){
			map_copy[i]	= map[i];	
		}
		return map_copy;
	}
	static boolean check(int map[], int n){
		int flag = 0;
		for(int i = 0; i < n; i++){
			for(int j = i * n ; j < (i + 1) * n; j++){
				if(map[j] == HOUSE)flag++;
				if(map[j] == WALL)flag = 0;
				if(flag == 2)return false;
			}
			flag = 0;
		}
		flag = 0;
		for(int i = 0; i < n; i++){
			for(int j = i; j <= i + ((n - 1) * n); j = j + n){
				if(map[j] == HOUSE)flag++;
				if(map[j] == WALL)flag = 0;
				if(flag == 2)return false;
			}
			flag = 0;
		}
		return flag >= 2 ? false : true;
	}
}

