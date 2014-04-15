import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {
	private static List<Integer> inputList = new ArrayList<Integer>();
	
	public static void init(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int temp = sc.nextInt();
			if(temp == 0)break;
			inputList.add(temp);
		}
	}
	
	public static void main(String[] args){
		init();
		for(Integer i : inputList){
			int m = 1;
		while(true){
			List<Integer> a = newList(i);
			m++;
			cutOff_2(a,m,0);
			if(a.get(0).intValue() == 2)break;
		}
		System.out.println(m);
		}
	}
	
	
	public static List<Integer> newList(int n){
		List<Integer> seqNumbers = new LinkedList<Integer>();
		for(int i = 0; i < n; i++){
			seqNumbers.add(i + 1);
		}
		return seqNumbers;
	}
	
	public static void cutOff_2(List<Integer> seqNumbers, int m, int delIndex){
		Iterator<Integer> it = seqNumbers.iterator();
		for(;it.hasNext() && seqNumbers.size() > 1;){
			it.next();
			if(delIndex == m)
				delIndex = 0;
			if(delIndex == 0)
				it.remove();
			delIndex++;
		}
		if(!it.hasNext() && seqNumbers.size() > 1){
			cutOff_2(seqNumbers, m , delIndex);
		}
	}
}
