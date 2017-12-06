import java.io.*;
import java.util.*;

public class solution2 {

    private void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        if (n == k || k == 0) {
            System.out.println(0 + " " + 0);
            return;
        }
        System.out.print(1 + " ");
        if (k <= n / 3) {
            System.out.println(k * 2);
            return;
        }
        System.out.println(n - k);

    }
    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    private String filename = "";
    private PrintWriter out;
    MyScanner in;

    private void run() throws IOException {
        in = new MyScanner();
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }
    private class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() throws IOException {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public MyScanner(String fileTitle) throws IOException {
            this.br = new BufferedReader(new FileReader(fileTitle));
        }

        public String nextLine() throws IOException {
            String s = br.readLine();
            return s == null ? "-1" : s;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return "-1";
                }
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        public Integer nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }

        public Double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }

        public void close() throws IOException {
            this.br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new solution2().run();
    }
}