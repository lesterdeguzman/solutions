/**
 * @(#)Eternal.java
 *
 *
 * @author
 * @version 1.00 2017/11/25
 */
import java.util.*;

public class Eternal {
    public static void main(String[] args) {

       long x;
       long y;
       long result = 1;
       Scanner sc = new Scanner(System.in);
       x = sc.nextLong();
       y = sc.nextLong();
       long count = y-x;

       if (x == 0){
		   x = 1;
       }

       for (int i=0; i<count; i++){
       	   if (result == 0){
       	   		break;
       	   }
       	   result *= (y%10);
       	   result %= 10;
       	   y--;
       }

       System.out.println(result%10);
       sc.close();
    }
}
