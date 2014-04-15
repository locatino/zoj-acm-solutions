import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class HumbleNumbers {
	public static List<Long> list = new ArrayList<Long>(5842);
	public static final long MAX = 2000000000;
	public static void init(){
		for(long i = 1; i <= MAX; i = i * 2){
			for(long j = 1; j <= MAX; j = j * 3){
				if(j * i > MAX)break;
				for(long h = 1; h <= MAX; h = h * 5){
					if(i * j * h > MAX)break;
					for(long k = 1; k <= MAX; k = k * 7){
						long t = i * j * k * h;
						if(t <= MAX)
							list.add(t);
					}
				}
			}
		}
		Collections.sort(list);
	}
	public static void main(String[] args){
		init();
		Scanner sc = new Scanner(System.in);
		while(true){
			int index = sc.nextInt();
			if(index == 0)break;
			String suffix = "th";
			if(index % 10 == 1 && index % 100 != 11){
				suffix = "st";
			}
			if(index % 10 == 2 && index % 100 != 12){
				suffix = "nd";
			}
			if(index % 10 == 3 && index % 100 != 13){
				suffix = "rd";
			}
			System.out.println("The " + index + suffix + " humble number is "+list.get(index - 1)+".");
		}
	}
}