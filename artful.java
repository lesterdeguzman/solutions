/**
 * @(#)Artful.java
 *
 * Artful application
 *
 * @author
 * @version 1.00 2017/11/25
 */
 import java.util.Scanner;
public class Artful {

    public static void main(String[] args) {
    	// TODO, add your application code
        Scanner kbd = new Scanner(System.in);
        while (kbd.hasNext()) {
             int a = kbd.nextInt();
             int[] b = new int[a];

             for(int i = 0; i < a; i++){
                 b[i]=kbd.nextInt();
             }

             int[] c = new int[a];
             for(int i = 0; i < b; i++){
                c[i] = kbd.nextInt();
             }

             System.out.println("Karen");
            }
