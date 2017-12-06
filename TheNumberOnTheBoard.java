import java.io.*;

import java.lang.Math;

import java.math.BigInteger;

import java.util.*;
import java.util.Map.Entry;

public class TheNumberOnTheBoard {
    static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    int                  INF          = -1000 * 1000 * 1000 - 100;
    Random               rnd          = new Random();
    String               delimiter    = " ";
    BufferedReader       in;
    PrintWriter          out;
    StringTokenizer      tok;

    TheNumberOnTheBoard() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in  = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in  = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }

        tok = new StringTokenizer("");
    }

    long binPow(long a, long b) {
        if (b == 0) {
            return 1;
        }

        if (b % 2 == 1) {
            return a * binPow(a, b - 1);
        } else {
            long c = binPow(a, b / 2);

            return c * c;
        }
    }

    long checkBit(long mask, int bit) {
        return (mask >> bit) & 1;
    }

    int countPow(int m, int n) {
        int ans = 0;

        while ((m % n == 0) && (m > 0)) {
            ans++;
            m /= n;
        }

        return ans;
    }

    int gcd(int a, int b) {
        return (b == 0)
               ? a
               : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        new TheNumberOnTheBoard().run();
    }

    long pow(long x, long k) {
        long ans = 1;

        for (int i = 0; i < k; ++i) {
            ans *= x;
        }

        return ans;
    }

    int[] rA(int b) {
        int a[] = new int[b];

        for (int i = 0; i < b; i++) {
            try {
                a[i] = rI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return a;
    }

    double rD() throws IOException {
        return Double.parseDouble(rS());
    }

    int rI() throws IOException {
        return Integer.parseInt(rS());
    }

    long rL() throws IOException {
        return Long.parseLong(rS());
    }

    String rS() throws IOException {
        while (!tok.hasMoreTokens()) {
            String nextLine = readLine();

            if (null == nextLine) {
                return null;
            }

            tok = new StringTokenizer(nextLine);
        }

        return tok.nextToken(delimiter);
    }

    String readLine() throws IOException {
        return in.readLine();
    }

    int[] readSortedIntArray(int size) throws IOException {
        Integer[] array = new Integer[size];

        for (int index = 0; index < size; ++index) {
            array[index] = rI();
        }

        Arrays.sort(array);

        int[] sortedArray = new int[size];

        for (int index = 0; index < size; ++index) {
            sortedArray[index] = array[index];
        }

        return sortedArray;
    }

    char[] reverseCharArray(char[] arr) {
        char[] ans = new char[arr.length];

        for (int i = 0; i < arr.length; ++i) {
            ans[i] = arr[arr.length - i - 1];
        }

        return ans;
    }

    void run() throws IOException {
        solve();
        out.close();
    }

    void solve() throws IOException {
        int    k   = rI();
        char[] s   = rS().toCharArray();
        int    n   = s.length;
        int[]  arr = new int[n];
        int    sum = 0;

        for (int i = 0; i < n; ++i) {
            sum    += s[i] - '0';
            arr[i] = s[i] - '0';
        }

        Arrays.sort(arr);

        int i = 0;

        while (sum < k) {
            sum += 9 - arr[i];
            i++;
        }

        out.println(i);
    }

    int[] sortedIntArray(int size, int[] array) throws IOException {
        for (int index = 0; index < size; ++index) {
            array[index] = rI();
        }

        Arrays.sort(array);

        int[] sortedArray = new int[size];

        for (int index = 0; index < size; ++index) {
            sortedArray[index] = array[index];
        }

        return sortedArray;
    }

    int sqrt(double m) {
        int l = 0;
        int r = 1000000000 + 9;
        int i = 1000;

        while (r - l > 1) {
            int mid = (r + l) / 2;

            if (mid * mid > m) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return l;
    }

    boolean isLower(char a) {
        return ((int) a) >= 97
               ? true
               : false;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
