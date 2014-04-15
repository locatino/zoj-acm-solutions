import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	private static List<String> inputList = new ArrayList<String>();
	private static List<String> outputList = new ArrayList<String>();
	private static final String hr = "-------------------------------------------------------------------------------- ";
	public static void main(String[] args){
		init();
		parse();
		for(String i : outputList){
			StringBuilder sb = new StringBuilder(i);
			if(sb.length() > 0){
			System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
			}else {
				System.out.println(sb.toString());
			}
		}
	}
	
	public static void parse(){
		StringBuilder sb = new StringBuilder();
		for(String i : inputList){
			if(i.equals("<br>")){
				outputList.add(sb.toString());
				if(sb.length() > 0){
					sb.delete(0, sb.length());
				}
				continue;
			}else if(i.equals("<hr>")){
				if(sb.length() > 0){
					outputList.add(sb.toString());
				}
				outputList.add(hr);
				sb.delete(0, sb.length());
				continue;
			}else if(sb.length() + i.length() <= 80){
				sb.append(i);
				sb.append(" ");
				continue;
			}else {
				outputList.add(sb.toString());
				sb.delete(0, sb.length());
				sb.append(i);
				sb.append(" ");
			}
		}
		outputList.add(sb.toString());
		
	}
	public static void init(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			inputList.add(sc.next());
		}
	}
}
