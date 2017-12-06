
/**
 * This program gives an output of two space-separated positive integers a and b, numerator and denominator of the maximum possible proper irreducible fraction satisfying the given sum.
 *
 * @author Kim Willy
 * @version 8.0
 * @since 2017-11-29
 */

import java.util.*;

public class Fraction {
     static int gcd(int a, int b) {
          if (b == 0) {
               return a;
          } else {
               return gcd(b, a % b);
          }
     }

     public static void main(String[] args) {
          Scanner s = new Scanner(System.in);
          int     n = s.nextInt();

          for (int i = n / 2; i > 0; i--) {
               if (gcd(i, n - i) == 1) {
                    System.out.println(i + " " + (n - i));

                    break;
               }
          }
     }
}



