package demo;
import java.util.Scanner;

/**
 * @(#)BetweenTheOffices.java
 *
 *
 * @author 
 * @version 1.00 2017/11/25
 */

public class BetweenTheOffices {

public static byte[] aa = new byte[100_000];

	public static void main(String[] args) {
		int a;
		a = STDIN_SCANNER.nextInt();
		for(int i = 1; i <= a; i++) {
			aa[i] = (byte)nextChar(STDIN_SCANNER);
		}
		if(aa[1] == 'S' && aa[a] == 'F') {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public final static Scanner STDIN_SCANNER = new Scanner(System.in);

	/**
	 * This method is missing from the Scanner interface.
	 */
	public final static int nextChar(Scanner scanner) {
		scanner.useDelimiter("");
		int ret = scanner.next().charAt(0);
		scanner.reset();
		return ret;
	}   
}