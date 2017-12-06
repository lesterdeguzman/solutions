 import java.util.*;
public class Fraction {
	static int gcd(int a,int b)
	{
		if(b==0) return a;
		else return gcd(b,a%b);
	}
    public static void main(String args[]){

    	Scanner kbd = new Scanner(System.in);

    	int n = kbd.nextInt();

    	int b = 1, c = n-1;

    	for(int i=2; i<(n/2+1) ;i++) {
    	  if(gcd(i,n-i) == 1) {
    		  b=i;
    		  c=n-i;
    	  }
    	}

    	System.out.println(b +" " +c);

    }
}