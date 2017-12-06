
/**
 * This is a program which will search for arbitrary values of the number n for all suitable values of x or determine that such x does not exist.
 *
 * @author Kim Willy
 * @version 8.0
 * @since 2017-11-29
 */

import java.util.Scanner;

public class ClassroomWatch{
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int n = kbd.nextInt();
		int k = 0;
		int[] array = new int[90];
		int k1 = k;
		for(int i = 1; i <= 81; i++) {

			int x = n - i;
			int sum = 0;

			while(x > 0) {

				sum += x % 10;
				x /= 10;
			}

			if(sum == i) {

				array[k1++] = n - i;
			}
		}

		k = k1;

		System.out.println(k);

		for(int i = k - 1; i >= 0; i--) {

			System.out.println(array[i]);
		}
	}
}
