/**
 * @(#)Maximum.java
 *
 * Maximum application
 *
 * @author
 * @version 1.00 2017/11/25
 */
 import java.util.Scanner;

public class Maximum {

	public static void main(String[] args) {
		// TODO, add your application code
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int num = s.nextInt();
			if (num % 4 == 0) {
				System.out.println(num / 4);
			} else if (num % 4 == 1) {
				if (num < 9) {
					System.out.println(-1);
				} else {
					System.out.println(((num - 9) / 4) + 1);
				}
			} else if (num % 4 == 2) {
				if (num < 6) {
					System.out.println(-1);
				} else {
					System.out.println(((num - 6) / 4) + 1);
				}
			} else if (num % 4 == 3) {
				if (num < 15) {
					System.out.println(-1);
				} else {
					System.out.println(((num - 15) / 4) + 2);
				}
			}
		}
	}
    }
}