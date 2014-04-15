import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
	
	private static Map<Character, String> encode = new HashMap<Character, String>();
	private static Map<String, Character> decode = new HashMap<String, Character>();
	
	
	public static void main(String[] args){
		init();
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int times = 1;
		while(count > 0 && sc.hasNext()){
			System.out.print(times + ": ");
			decoding(sc.next());
			count--;
			times++;
		}
		
	}
	
	public static void encoding(String s){
		StringBuilder sb = new StringBuilder();
		for(char i : s.toCharArray()){
			sb.append(encode.get(i));
		}
		System.out.println(sb.toString());
	}
	
	public static void decoding(String s){
		StringBuilder sb_code = new StringBuilder();
		StringBuilder sb_len = new StringBuilder();
		StringBuilder sb_de = new StringBuilder();
		for(char i : s.toCharArray()){
			String temp = encode.get(i);
			sb_code.append(temp);
			sb_len.append(temp.length());
		}
		sb_len.reverse();
		int len = 0;
		int index = 0;
		len = Integer.parseInt(sb_len.toString().substring(index, index + 1));
		StringBuilder temp = new StringBuilder();
		for(char i : sb_code.toString().toCharArray()){
			if(len == 0){
				index++;
				len = Integer.parseInt(sb_len.toString().substring(index, index + 1));
				sb_de.append(decode.get(temp.toString()));
				temp= new StringBuilder();
			}
			temp.append(i);
			len--;		
		}
		sb_de.append(decode.get(temp.toString()));
		System.out.println(sb_de.toString());
	}
	
	public static void init(){
		encode.put('A', "*=");
		decode.put("*=", 'A');
		
		encode.put('B', "=***");
		decode.put("=***", 'B');
		
		encode.put('C', "=*=*");
		decode.put("=*=*", 'C');
		
		encode.put('D', "=**");
		decode.put("=**", 'D');
		
		encode.put('E', "*");
		decode.put("*", 'E');
		
		encode.put('F', "**=*");
		decode.put("**=*", 'F');
		
		encode.put('G', "==*");
		decode.put("==*", 'G');
		
		
		encode.put('H', "****");
		decode.put("****", 'H');
		
		encode.put('I', "**");
		decode.put("**", 'I');
		
		encode.put('J', "*===");
		decode.put("*===", 'J');
		
		encode.put('K', "=*=");
		decode.put("=*=", 'K');
		
		encode.put('L', "*=**");
		decode.put("*=**", 'L');
		
		encode.put('M', "==");
		decode.put("==", 'M');
		
		encode.put('N', "=*");
		decode.put("=*", 'N');
		
		encode.put('O', "===");
		decode.put("===", 'O');
		
		encode.put('P', "*==*");
		decode.put("*==*", 'P');
		
		encode.put('Q', "==*=");
		decode.put("==*=", 'Q');
		
		encode.put('R', "*=*");
		decode.put("*=*", 'R');
		
		encode.put('S', "***");
		decode.put("***", 'S');
		
		encode.put('T', "=");
		decode.put("=", 'T');
		
		encode.put('T', "=");
		decode.put("=", 'T');
		
		encode.put('U', "**=");
		decode.put("**=", 'U');
		
		encode.put('V', "***=");
		decode.put("***=", 'V');
		
		encode.put('W', "*==");
		decode.put("*==", 'W');
		
		encode.put('X', "=**=");
		decode.put("=**=", 'X');
		
		encode.put('Y', "=*==");
		decode.put("=*==", 'Y');
		
		encode.put('Z', "==**");
		decode.put("==**", 'Z');
		
		encode.put('_', "**==");
		decode.put("**==", '_');
		
		encode.put(',', "*=*=");
		decode.put("*=*=", ',');
		
		encode.put('.', "===*");
		decode.put("===*", '.');
		
		encode.put('?', "====");
		decode.put("====", '?');
	}	
}