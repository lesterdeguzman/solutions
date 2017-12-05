//Problem 877B - Nikita and string

import java.util.*;

public class NikitaString{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String in = sc.nextLine();
			int part1 = 0;
			int part2 = 0;
			int part3 = 0;
			for(int i = 0;i < in.length();i ++){
				if(in.charAt(i) == 'a'){
					part1 ++;part3 ++;
				}
				if(in.charAt(i) == 'b'){
					part2 ++;
				}
				part2 = Math.max(part1,part2);
				part3 = Math.max(part3,part2);
				//System.out.print(part1 + " ");
				//System.out.print(part2 + " ");
				//System.out.println(part3);
			}
			System.out.println(part3);
		}
	}
}
	