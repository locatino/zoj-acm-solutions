import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	private static List<String> targetList = new ArrayList<String>();
	private static List<String> sourceList = new ArrayList<String>();
	
	public static void initInput(){
		Scanner sc = new Scanner(System.in);
		int count = 16;
		while(sc.hasNext()){
			String temp = sc.nextLine();
			if(temp.equals("-1 -1 -1"))break;
			if(count > 0){
				targetList.add(temp);
			}else{
				sourceList.add(temp);
			}
			count--;
		}
	}
	public static void main(String[] args){
		initInput();
		for(String i : sourceList){
			double minDis = Double.MAX_VALUE;
			String targetPoint = null;
			for(String j : targetList){
				double temp = calcMinDistance(i, j);
				if(temp < minDis){
					minDis = temp;
					targetPoint = j;
				}
			}
			System.out.println("("+ parstOutput(i) + ")" + " maps to " + "("+ parstOutput(targetPoint) + ")");
		}
	}
	public static String parstOutput(String s){
		StringBuilder sb = new StringBuilder();
		for(String i : s.split(" ")){
			sb.append(i);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	public static double calcMinDistance(String source, String target){
		double source_R, source_G, source_B;
		String[] src = source.split(" ");
		source_R = Double.parseDouble(src[0]);
		source_G = Double.parseDouble(src[1]);
		source_B = Double.parseDouble(src[2]);
		
		double target_R, target_G, target_B;
		String[] tar = target.split(" ");
		target_R = Double.parseDouble(tar[0]);
		target_G = Double.parseDouble(tar[1]);
		target_B = Double.parseDouble(tar[2]);
		
		return Math.sqrt(Math.pow((target_R - source_R),2) +Math.pow((target_G - source_G),2) + Math.pow((target_B - source_B),2));
		
	}
	public static void print(Object obj){
		System.out.println(obj.toString());
	}
}
