import java.io.*;
import java.util.*;

public class SlavaAndTanks {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
}

class Task {

    //    static int MAX = 1000001;
//    List<List<Integer>> g = new ArrayList<>();
//    int n;
    //    char[] s;
//    int a[];
//    boolean used[];
//    int[] res;

//    public void solve(Scanner in, PrintWriter out) {
//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//            solve1(in, out);
//        }
//    }

    public void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n; i+=2) {
            res.add(i);
        }
        for (int i = 1; i <= n; i+=2) {
            res.add(i);
        }
        for (int i = 2; i <= n; i+=2) {
            res.add(i);
        }
        out.println(res.size());
        for (Integer re : res) {
            out.print(re + " ");
        }
    }

}

class Utils {

    public static int binarySearch(int[] a, int key) {
        int s = 0;
        int f = a.length;
        while (f > s) {
            int mid = (s + f) / 2;
            if (a[mid] > key) {
                f = mid - 1;
            } else if (a[mid] <= key) {
                s = mid + 1;
            }
        }
        return -1;
    }

    public static long gcd(long a, long b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static List<Integer> prime(int number) {
        List<Integer> a = new ArrayList<>();
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                a.add(i);
                number /= i;
                i = 1;
            }
        }
        a.add(number);
        return a;
    }
}

class Pair<T, U> {
    public T a;
    public U b;

    public Pair(T a, U b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (a != null ? !a.equals(pair.a) : pair.a != null) return false;
        return b != null ? b.equals(pair.b) : pair.b == null;
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }
}


class Vect {
    public int a;
    public int b;

    public Vect(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vect vect = (Vect) o;

        if (a != vect.a) return false;
        return b == vect.b;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        return result;
    }
}

class Tri {
    public int a;
    public int b;
    public int c;

    public Tri(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

class Triple<T, U, P> {
    public T a;
    public U b;
    public P c;

    public Triple(T a, U b, P c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;

        if (a != null ? !a.equals(triple.a) : triple.a != null) return false;
        return b != null ? b.equals(triple.b) : triple.b == null;
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }
}


class Scanner {
    BufferedReader in;
    StringTokenizer tok;

    public Scanner(InputStream in) {
        this.in = new BufferedReader(new InputStreamReader(in));
        tok = new StringTokenizer("");
    }

    private String tryReadNextLine() {
        try {
            return in.readLine();
        } catch (Exception e) {
            throw new InputMismatchException();
        }
    }

    public String nextToken() {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(next());
        }
        return tok.nextToken();
    }

    public String next() {
        String newLine = tryReadNextLine();
        if (newLine == null)
            throw new InputMismatchException();
        return newLine;
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }
}