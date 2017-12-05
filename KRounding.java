/**
 * @(#)KRounding.java
 *
 *
 * @author
 * @version 1.00 2017/11/25
 */
import java.util.*;

public class KRounding {
    public static void main(String[] args) {
    		Scanner s = new Scanner(System.in);
    		long a, b;
    		a = s.nextLong();
    		b = s.nextLong();
    		for(long i=0; i<b; i++){
    				if(a%2==0){
    					a/=2;
    				}
    				if (a%5==0){
    					a/=5;
    				}
    		}
    		System.out.print((int)a);
    		for(long i=0; i<b; i++){
    				System.out.print("0");
    		}
    }
}
