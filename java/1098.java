import java.util.Scanner;


public class SimpleComputer {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int[] memory = new int[32];
			for(int i = 0; i < 32; i++){
				String bi = sc.next();
				memory[i] = Integer.parseInt(bi, 2);
			}
			int accu = 0;
			int pc = 0;
			boolean terminated = false;
			while(true){
				if(pc >= 32)pc = 0;
				int instruction = (memory[pc] >> 5);
				int memAddr = (memory[pc] & 31);
				switch(instruction){
				case 0:
					memory[memAddr] = accu;
					pc++;
					break;
				case 1:
					accu = memory[memAddr];
					pc++;
					break;
				case 2:
					if(accu == 0)pc = memAddr;
					else pc++;
					break;
				case 3:
					pc++;
					break;
				case 4:
					accu--;
					if(accu < 0)accu = 255;
					pc++;
					break;
				case 5:
					accu++;
					if(accu > 255)accu = 0;
					pc++;
					break;
				case 6:
					pc = memAddr;
					break;
				case 7:
					terminated = true;
					break;
				}
				if(terminated)break;
			}
			StringBuilder sb = new StringBuilder();
			String bin = Integer.toBinaryString(accu);
			for(int i = 0; i < 8 - bin.length(); i++){
				sb.append(0);
			}
			sb.append(bin);
			System.out.println(sb.toString());
		}
	}
}
