//Problem 873A - Chores

import java.util.Scanner;

public class Chores {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt(), k = s.nextInt(), x = s.nextInt();
    int r = x * k;
    for (int i = 0; i < n - k; i++) {
      r += s.nextInt();
    }
    System.out.println(r);
  }
}