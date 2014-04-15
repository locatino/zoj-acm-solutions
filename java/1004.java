import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 0ÊÇout 1ÊÇin
 * @author Administrator
 *
 */
public class Main {
	static final char IN = 'i';
	static final char OUT = 'o';
	
	class Node{
		Node left;
		Node right;
		
		char op;
		
		
		StringBuilder input;
		StringBuilder stack;
		StringBuilder output;
		StringBuilder opSeq;
		
		Node(StringBuilder input,StringBuilder stack, StringBuilder output, StringBuilder opSeq){
			this.output = new StringBuilder(output);
			this.opSeq = new StringBuilder(opSeq);
			
			if(stack.length() == 0)left = null;
			else {
				this.input = new StringBuilder(input);
				this.stack = new StringBuilder(stack);
				this.output = new StringBuilder(output);
				this.opSeq = new StringBuilder(opSeq);
				char pop = this.stack.charAt(stack.length() - 1);
				this.stack.deleteCharAt(stack.length() - 1);
				this.output.append(pop);
				this.op = OUT;
				this.opSeq.append(this.op);
				left = new Node(this.input, this.stack,this.output, this.opSeq);
				
			}
			if(input.length() > 0){
				this.input = new StringBuilder(input);
				this.stack = new StringBuilder(stack);
				this.output = new StringBuilder(output);
				this.opSeq = new StringBuilder(opSeq);
				
				this.stack.append(this.input.charAt(0));
				this.input.deleteCharAt(0);
				this.op = IN;
				this.opSeq.append(this.op);
				right = new Node(this.input, this.stack ,this.output,this.opSeq);
			}else right = null;
		}
	}
	
	static void DFS(Node node, String target){
		if(node.left != null)DFS(node.left, target);
		if(node.right != null)DFS(node.right, target);
		if(node.left == null && node.right == null){
			if(node.output.toString().equals(target)){
//				System.out.println(node.output);
//				System.out.println(node.opSeq);
				result.add(node.opSeq.toString());
			}
		}
	}
	
	static List<String> result = new ArrayList<String>();
	public static void main(String[] args){
		Main node = new Main();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String source = sc.next();
			String target = sc.next();
			DFS(node.new Node(new StringBuilder(source), new StringBuilder(), new StringBuilder(), new StringBuilder(0)), target);
			Collections.sort(result);
			System.out.println("[");
			for(String i : result){
				for(char c : i.toCharArray()){
					System.out.print(c);
					System.out.print(" ");
				}
				System.out.println();
			}
			System.out.println("]");
			result.clear();
		}
	}
}
