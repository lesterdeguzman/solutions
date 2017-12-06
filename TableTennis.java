import java.util.Scanner;
public class TableTennis{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfPeople = scan.nextInt();
		long j = scan.nextInt();
		int numOfWins = scan.nextInt();
		long k = 0;
		
		for(int i = 1; i < numOfPeople; i++) {
			int c = sc.nextInt();
			if (c > numOfWins) {
				k = 1;
				numOfWins = c;
			}else {
				k++;
			}
			if (k >= j) {
				break;
			}
		}
		System.out.print(numOfWins);
	}
}