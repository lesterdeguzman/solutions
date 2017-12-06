 import java.util.Scanner;
public class LazySecurityGuard {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double n = input.nextFloat();
        double x = Math.ceil(Math.sqrt(n));

        x += x * (x - 1) < n ? x : x - 1;
        System.out.println((int) x * 2);
    }
}