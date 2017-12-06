import java.util.Scanner;

public class tripForMeal876A {
     public static void main(String[] args) {
          Scanner ab   = new Scanner(System.in);
          int     num  = ab.nextInt();
          int     a    = ab.nextInt();
          int     b    = ab.nextInt();
          int     c    = ab.nextInt();

          int     dist = 0;

          num--;

          if (num-- > 0) {
               dist += Math.min(a, b);
          }

          if (dist > 0) {
               dist += num * Math.min(Math.min(a, b), c);
          }

          System.out.println(dist);

     }
}