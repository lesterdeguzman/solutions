//Problem 876A - Trip For Meal

import java.util.Scanner;

public class TripForMeal {

	// 13:12-
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int dist = 0;
		num--;
		
		if (num-- > 0) dist += Math.min(a, b);
		if (dist > 0) dist += num * Math.min(Math.min(a, b), c);

		System.out.println(dist);
	}
}