
/*
*@author Vinalyn Zamora
*
*
**/
import java.io.BufferedReader;
import java.io.IOException;

//import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

import static java.util.Arrays.copyOf;
import static java.util.Arrays.fill;
import static java.util.Arrays.sort;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

public class RestorationOfString {
    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new RestorationOfString().run();
    }

    private void run() throws IOException {
        in = new FastScanner(System.in);

        // in = new FastScanner(new FileInputStream(".in"));
        out = new PrintWriter(System.out);

        // out = new PrintWriter(new FileOutputStream(".out"));
        solve();
        out.flush();
        out.close();
    }

    private void solve() throws IOException {
        int      n       = in.nextInt();
        char[][] strings = new char[n][];

        for (int i = 0; i < n; i++) {
            strings[i] = in.nextLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                strings[i][j] -= 'a';
            }
        }

        int       alphabet = 'z' + 1 - 'a';
        boolean[] have     = new boolean[alphabet];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                have[strings[i][j]] = true;
            }
        }

        int[] next = new int[alphabet];

        fill(next, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j + 1 < strings[i].length; j++) {
                if (next[strings[i][j]] == -1) {
                    next[strings[i][j]] = strings[i][j + 1];
                } else if (next[strings[i][j]] != strings[i][j + 1]) {
                    out.print("NO");

                    return;
                }
            }
        }

        boolean[] begin = new boolean[alphabet];

        fill(begin, true);

        for (int i = 0; i < alphabet; i++) {
            if (next[i] != -1) {
                begin[next[i]] = false;
            }
        }

        boolean[]     used = new boolean[alphabet];
        StringBuilder ans  = new StringBuilder();

        for (int i = 0; i < alphabet; i++) {
            if (have[i] &&!used[i] && begin[i]) {
                for (int j = i; j != -1; j = next[j]) {
                    if (used[j]) {
                        out.print("NO");

                        return;
                    }

                    ans.append((char) (j + 'a'));
                    used[j] = true;
                }
            }
        }

        for (int i = 0; i < alphabet; i++) {
            if (have[i] &&!used[i]) {
                out.print("NO");

                return;
            }
        }

        out.print(ans.toString());
    }

    class FastScanner {
        StringTokenizer st;
        BufferedReader  br;

        FastScanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        String next() throws IOException {
            while ((st == null) ||!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }

            return st.nextToken();
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        boolean hasNext() throws IOException {
            return br.ready() || ((st != null) && st.hasMoreTokens());
        }

        boolean hasNextLine() throws IOException {
            return br.ready();
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
