import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static List<Character> charSet = new ArrayList<Character>();
	public static List<Character> cipherText = new ArrayList<Character>();
	public static List<Integer> plainCode = new ArrayList<Integer>();
	public static List<Integer> cipherCode = new ArrayList<Integer>();
	public static String plainText;
	public static void initCharSet(){
		charSet.add('_');
		for(int i = 0; i < 26; i++){
			charSet.add((char)('a'+i));
		}
		charSet.add('.');
	}
	public static void initCipherCode(String code){
		cipherCode.clear();
		for(int i = 0; i < code.length(); i++){
			cipherCode.add(-1);
		}
	}
	public static void main(String[] args){
		int key = -1;
		initCharSet();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			key = sc.nextInt();
			if(key == 0)return;
			plainText = sc.next();
			initPlainCode(plainText);
			decode(plainText,key);
			for(int i = 0; i < cipherText.size(); i++){
				System.out.print(cipherText.get(i));
			}
			System.out.println();
		}
		
	}
	public static void decode(String code, int key){
		cipherText.clear();
		initCipherCode(code);
		int cipherCodeInst;
		for(int i = 0; i < code.length(); i++){
			cipherCodeInst = plainCode.get(i);
			cipherCodeInst += i;
			while(cipherCodeInst >= 28)cipherCodeInst -= 28;
			plainCode.indexOf(cipherCodeInst);
			cipherCode.set((key*i)%code.length(),cipherCodeInst);
		}
		for(Integer i : cipherCode){
			cipherText.add(charSet.get(i));
		}
		
	}
	public static void initPlainCode(String code){
		plainCode.clear();
		for(int i = 0; i < code.length(); i++)
		plainCode.add(charSet.indexOf(code.charAt(i)));
	}
}

/*
 * ciphercode[i] = (plaincode[ki mod n] - i) mod 28.
*/
