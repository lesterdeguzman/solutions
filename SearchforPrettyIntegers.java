import java.io.*;
import java.math.*;
import java.util.*;
	   public class SearchforPrettyIntegers{
		private InputStream is;
		private PrintWriter out;
		static int MOD = (int)(1e9+7);
		ArrayList<Integer>[] amp;
		public static void main(String[] args) throws Exception {
			new Thread(null, new Runnable() {
			public void run() {
				try {
	 } catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}, "1", 1 << 26).start();
			new SearchforPrettyIntegers().soln();
		}
		char ch[][];
		static ArrayList<Integer>[] g;
        static ArrayList<Integer> ar[];
		static long ok[];
		static char a[][];
		static int phi[]=new int[500005];
		void solve()
        {
		int n=ni();
		int m=ni();
		int min1=10;
		int min2=10;
		int a[]=na(n);
		int b[]=na(m);
		int ans=100;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				int x=a[i]+(10*b[j]);
				int y=(a[i]*10)+b[j];
				if(ans>x)
					ans=x;
				if(ans>y)
					ans=y;
				if(a[i]==b[j])
					if(ans>a[i])
						ans=a[i];
			}
		}
		out.println(ans);

        }



		public static int find(int v,int start,int end,int l,int r){
    	    if(r < start || end < l)
    	    {
    	    	return 0;
    	    }
    	    if(l <= start && end <= r)
    	    {
    	        return (tre[v]);
    	    }
    	    int mid = (start + end) / 2;
    	    int p1 = find(2*v, start, mid, l, r);
    	    int p2 = find(2*v+1, mid+1, end, l, r);
    	    return p1+p2;
    	}
		static int tre[]=new int[4000005];
		public static void Update(int v,int tl,int tr,int index,int val){
    		if(tl==tr)
    		{
    			tre[v]=val;
    		}
    		else
    		{
    			int mid=(tl+tr)/2;
    			if(tl <= index &&index <= mid)
    	        {
    	            Update(2*v,tl, mid, index, val);
    	        }
    	        else
    	        {
    	        	Update(2*v+1,mid+1,tr, index, val);
    	        }
    			tre[v]=((tre[2*v]+tre[2*v+1]));
    		}
    	}

		public static int find1(int v,int start,int end,int l,int r)
    	{
    	    if(r < start || end < l)
    	    {
    	    	return 0;
    	    }
    	    if(l <= start && end <= r)
    	    {
    	        return (tre1[v]);
    	    }
    	    int mid = (start + end) / 2;
    	    int p1 = find1(2*v, start, mid, l, r);
    	    int p2 = find1(2*v+1, mid+1, end, l, r);
    	    return Math.max(p1, p2);
    	}
		static int tre1[]=new int[8000005];
		public static void Update1(int v,int tl,int tr,int index,int val)
    	{
    		if(tl==tr)
    		{
    			tre1[v]=val;
    		}
    		else
    		{
    			int mid=(tl+tr)/2;
    			if(tl <= index &&index <= mid)
    	        {
    	            Update1(2*v,tl, mid, index, val);
    	        }
    	        else
    	        {
    	        	Update1(2*v+1,mid+1,tr, index, val);
    	        }
    			tre1[v]=(Math.max(tre1[2*v],tre1[2*v+1]));
    		}
    	}

            boolean isPrime(int x)
            {
            if(x==0||x==1)
            	return false;
			for(int i = 2;i*1L*i<=x;i++) if(x%i==0) return false;
			return true;
		}
	    int  p ;
	    long modInverse(long a, long mOD2){
	        return  power(a, mOD2-2, mOD2);
		}
		long power(long x, long y, long m)
		{
		if (y == 0)
	    return 1;
		long p = power(x, y/2, m) % m;
		p = (p * p) % m;

		return (y%2 == 0)? p : (x * p) % m;
		}
		public static long gcd(long a, long b){
			if(b==0) return a;
			return gcd(b,a%b);
		}
		class Pair1 implements Comparable<Pair1>{
			long a;
			long b;
			long c;
			Pair1(long x,long y,long z){
			this.a=x;
			this.b=y;
			this.c=z;
			}
			public int hashCode() {
				return Objects.hash();
			}

			@Override
			public int compareTo(Pair1 arg0) {
				return (int)(arg0.c-c);
			}
		}
		long power(long x, long y, int mod){
			long ans = 1;
			while(y>0){
				if(y%2==0){
					x = (x*x)%mod;
					y/=2;
				}
				else{
					ans = (x*ans)%mod;
					y--;
				}
			}
			return ans;
		}
		void soln() {
			is = System.in;
			out = new PrintWriter(System.out);
			long s = System.currentTimeMillis();
			solve();
            out.flush();
		}
 		private byte[] inbuf = new byte[1024];
		public int lenbuf = 0, ptrbuf = 0;
		private int readByte() {
			if (lenbuf == -1)
				throw new InputMismatchException();
			if (ptrbuf >= lenbuf) {
				ptrbuf = 0;
				try {
					lenbuf = is.read(inbuf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (lenbuf <= 0)
					return -1;
			}
			return inbuf[ptrbuf++];
		}
		private boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}
		private int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}
		private double nd() {
			return Double.parseDouble(ns());
		}
		private char nc() {
			return (char) skip();
		}
		private String ns() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}
		private char[] ns(int n) {
			char[] buf = new char[n];
			int b = skip(), p = 0;
			while (p < n && !(isSpaceChar(b))) {
				buf[p++] = (char) b;
				b = readByte();
			}
			return n == p ? buf : Arrays.copyOf(buf, p);
		}
		private int[][] nm(int n, int m) {
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++)
			{
				for(int j=0;j<m;j++)
					map[i][j]=ni();
			}
			return map;
		}
		private int[] na(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = ni();
			return a;
		}
		private int ni() {
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}
			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}
		private long nl() {
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}
			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}
		private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
		private void tr(Object... o) {
			if (!oj)
				System.out.println(Arrays.deepToString(o));
		}
	}