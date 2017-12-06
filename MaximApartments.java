
    	/**
 * @(#)Apartment.java
 *
 * Apartment application
 *
 * @author
 * @version 1.00 2017/11/25
 */
import java.util.*;
import java.util.Scanner;

public class MaximApartments {

    public static void main(String[] args) {

    	// TODO, add your application code
        Scanner kbd = new Scanner(System.in);
        int a = kbd.nextInt(), b = kbd.nextInt();
        if (b == 0) {
            System.out.println(0 + " " + 0);
            return;
        }
        int min = Math.min(a - b, 1), max;
        if ((a - b)/b >= 2) max =  b*2;
        else max = a-b;

        System.out.println(min + " " + max);
    }
}
    }
}
