
/*
*@author Vinalyn Zamora
*
*862A-Mahmoud and Ehab and the MEX
*
**/
import java.util.Arrays;
import java.util.Scanner;

public class MEX {
    public static void main(String[] args) {
        int     n, x, num,
                mex      = -1, req;
        Scanner keyboard = new Scanner(System.in);

        n = keyboard.nextInt();
        x = keyboard.nextInt();

        int[]     a     = new int[n];
        boolean[] array = new boolean[101];

        Arrays.fill(array, false);
        req = getMex(n, x, mex, keyboard, array);
        System.out.println(req);
    }

    public static int getMex(int n, int x, int mex, Scanner keyboard, boolean[] array) {
        int num;
        int req;

        for (int i = 0; i < n; i++) {
            num        = keyboard.nextInt();
            array[num] = true;
        }

        int len = array.length;

        for (int i = 0; i < len; i++) {
            if (array[i] == false) {
                mex = i;

                break;
            }
        }

        if (mex == x) {
            req = 0;
        } else if (mex > x) {
            req = 1;
        } else {
            int count = 0;

            for (int i = mex; i < x; i++) {
                if (array[i] == false) {
                    count++;
                }
            }

            if (array[x] == true) {
                count++;
            }

            req = count;
        }

        return req;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
