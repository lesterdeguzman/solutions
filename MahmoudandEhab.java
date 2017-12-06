import java.io.*;
	import java.util.*;


	   public class MahmoudandEhab{



		   public static void main(String[] args) {


			 int n = sc.nextInt();
			 int x = sc.nextInt();

			 int arr[] = new int[n];
			 HashSet<Integer> set = new HashSet<Integer>();
			 for(int i=0;i<n;i++){arr[i]=sc.nextInt(); set.add(arr[i]); }

			 int ctr=0;

			 for(int ni =0;ni<=100;ni++)
			 {

				 if(!set.contains(ni))
				 {

					 if(ni==x)break;
					 if(ni>x)break;
					 ctr++;

				 }else
				 {
					 if(x==ni)ctr++;
				 }

			 }

				pw.println(ctr);
				    pw.close();

			}



		public static long fact(long x)
		{
			if(x==0)return 1;
			else return x*fact(x-1);
		}


		public static long exp(long x, long n, long M)
		{

			if(n==0) return 1;

			else if(n%2==0) return exp((x*x)%M,n/2,M);
			else return (x*exp((x*x)%M,(n-1)/2,M))%M;

		}

		//fi

		static long fib(long n)
		{
			long F[][] = new long[][]{{1,1},{1,0}};
			if (n == 0)
				return 0;
			power(F, n-1);

			return F[0][0];
		}

		static int mod=1000000007;

		static void multiply(long F[][], long M[][])
		{
			long x =  (((F[0][0]%mod)*(M[0][0]%mod))%mod + ((F[0][1]%mod)*(M[1][0]%mod))%mod)%mod;
			long y =  (((F[0][0]%mod)*(M[0][1]%mod))%mod + ((F[0][1]%mod)*(M[1][1]%mod))%mod)%mod;
			long z =  (((F[1][0]%mod)*(M[0][0]%mod))%mod + ((F[1][1]%mod)*(M[1][0]%mod))%mod)%mod;
			long w =  (((F[1][0]%mod)*(M[0][1]%mod))%mod + ((F[1][1]%mod)*(M[1][1]%mod))%mod)%mod;

			F[0][0] = x;
			F[0][1] = y;
			F[1][0] = z;
			F[1][1] = w;
		}

		/* Optimized version of power() in method 4 */
		static void power(long F[][], long n)
		{
			if( n == 0 || n == 1)
				return;
			long M[][] = new long[][]{{1,1},{1,0}};

			power(F, n/2);
			multiply(F, F);

			if (n%2 != 0)
				multiply(F, M);
		}




		public static int gcd(int a, int b)
		{
			if(b==0)
				return a;
			else return gcd(b,a%b);
		}

		static  class MyScanner {

			BufferedReader br;
			StringTokenizer st;

			public MyScanner() {
				br = new BufferedReader(new InputStreamReader(System.in));
			}

			String next() {
				while (st == null || !st.hasMoreElements()) {
					try {
						st = new StringTokenizer(br.readLine());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return st.nextToken();
			}

			int nextInt() {
				return Integer.parseInt(next());
			}

			long nextLong() {
				return Long.parseLong(next());
			}

			double nextDouble() {
				return Double.parseDouble(next());
			}

			String nextLine(){
				String str = "";
				try {
					str = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return str;
			}

		}

		static MyScanner sc = new  MyScanner();
		static PrintWriter pw = new PrintWriter(System.out, true);



		static void printPath(int parent[], int j)
		{
		    // Base Case : If j is source
		    if (parent[j]==-1)
		        {pw.print(j+" ");return;}

		    printPath(parent, parent[j]);

		    pw.print(j+" ");
		}
	  		//Main begins here ??
	/*
		public static class Pair{
		    int a;
		    int b;
		    Pair(int p,int q){
		        a=p;
		        b=q;
		    }
		    public boolean equals(Object o) {
		        if (o instanceof Pair) {
		            Pair p = (Pair)o;
		            return p.a == a && p.b == b;
		        }
		        return false;
		    }
		    public int hashCode() {
		        return new Integer(a).hashCode() * 31 + new Integer(b).hashCode();
		    }
		}
		*/




		public static int max1(String st, int k)
		{
			int n1=0;
			int max=Integer.MIN_VALUE;
			int n = st.length();
			if(n==1)
			{
				if(st.charAt(0)=='1')return 1;
				else return 0;
			}

			for(int i=1;i<=k;i++)
			{
				int chp=i-1;

				if(st.charAt(chp)=='1')n1++;

			}
			max=Math.max(max, n1);
		//	if(k>=n)return max;
			int slides=n-k;
			int ptr1=0, ptr2=k-1;

			for(int i=1;i<=slides;i++)
			{
				//pw.println(st.substring(ptr1+i, ptr2+i+1));
				ptr1++; ptr2++;
				if(st.charAt(ptr1-1)=='1')n1--;
				if(st.charAt(ptr2)=='1')n1++;
				//pw.println("m1- "+n1);pw

				if(n1>max)max=n1;
				if(max==k){return k;}
			}

			return max;

		}


		public static String shift(String A)
		{
			char lc = A.charAt(A.length()-1);
			return lc+A.substring(0,A.length()-1);

		}








		public static int lucky(long y)
		{

			long d = y;
			int flg=0;
			//long nd = (long)Math.floor(Math.log10((double)y));
			//pw.println(nd);
			for(;d>=1;d=d/10)
			{
				long dg = d%10;
				if(dg!=0)flg++;
				if(flg==2)return 0;

			}
			return 1;

		}

		public static int diff(Time n, Time k)
		{

			int hn=n.h,mn=n.m,sn=n.s;
			int hk=k.h,mk=k.m,sk=k.s;


			int tc=0,cs=0,cm=0,ch=0;
			if(sk>sn)
			{
				int o1 = sk-sn;
				int o2 = sn+60-sk;

				if(o1>o2)
				{
					cs=o2;
					mn--;
				}
				if(o2>o1)
				{
					cs=o1;
				}
				if(o1==o2)
				{

					int min1 = Math.min(Math.abs(mk-mn), 60 - Math.abs(mk-mn));
					int mn2 = mn-1;
					int min2  = Math.min(Math.abs(mk-mn2), 60 - Math.abs(mk-mn2));
					if(min2<min1)
					{
						cs=o2;
						mn--;
					}
					else
					{
						cs=o1;
					}

				}
			}

			if(sk<sn)
			{
				int o1 = sn-sk;
				int o2 = sk+60-sn;

				if(o1>o2)
				{
					cs=o2;
					mn++;
				}
				if(o2>o1)
				{
					cs=o1;
				}
				if(o1==o2)
				{

					int min1 = Math.min(Math.abs(mk-mn), 60 - Math.abs(mk-mn));
					int mn2 = mn+1;
					int min2  = Math.min(Math.abs(mk-mn2), 60 - Math.abs(mk-mn2));
					if(min2<min1)
					{
						cs=o2;
						mn++;
					}
					else
					{
						cs=o1;
					}

				}
			}

			if(mk>mn)
			{
				int o1 = mk-mn;
				int o2 = mn+60-mk;

				if(o1>o2)
				{
					cm=o2;
					hn--;
				}
				if(o2>o1)
				{
					cm=o1;
				}
				if(o1==o2)
				{
					int min1 = Math.min(Math.abs(hk-hn), 24 - Math.abs(hk-hn));
					int hn2 = hn-1;
					int min2  = Math.min(Math.abs(hk-hn2), 24 - Math.abs(hk-hn2));
					if(min2<min1)
					{
						cm=o2;
						hn--;
					}
					else
					{
						cm=o1;
					}
				}
			}

			if(mk<mn)
			{
				int o1 = mn-mk;
				int o2 = mk+60-mn;

				if(o1>o2)
				{
					cm=o2;
					hn++;
				}
				if(o2>o1)
				{
					cm=o1;
				}
				if(o1==o2)
				{
					int min1 = Math.min(Math.abs(hk-hn), 24 - Math.abs(hk-hn));
					int hn2 = hn+1;
					int min2  = Math.min(Math.abs(hk-hn2), 24 - Math.abs(hk-hn2));
					if(min2<min1)
					{
						cm=o2;
						hn++;
					}
					else
					{
						cm=o1;
					}
				}
			}

			ch = Math.min(Math.abs(hk-hn), 24 - Math.abs(hk-hn));
			tc=cs+cm+ch;
			return tc;



			//return 3;
		}



		public static class Time
		{
			int h,m,s;

			public Time(int x, int y, int z)
			{
				h=x; m=y; s=z;

			}

		}

		static class Pair
		{
		    int x;
		    int y;

		    public Pair(int a , int b)
		    {
		        x=a;
		        y=b;
		    }


		}

		static class comp implements Comparator<Pair>
		{

		    @Override

		    public int compare(Pair a ,Pair b)
		    {
		        if(b.x>a.x)return -1;
		        if(b.x<a.x)return 1;
		        return 0;

		    }

		}
		static class compv implements Comparator<Vouch>
		{

		    @Override

		    public int compare(Vouch a ,Vouch b)
		    {
		        if(b.c>a.c)return -1;
		        if(b.c<a.c)return 1;
		        return 0;

		    }

		}

		static class Vouch
		{
		   int l,r, c;


		    public Vouch(int a ,int b, int ci)
		    {
		        l=a;
		        r=b;
		        c=ci;

		    }

		}





		public static int strStr(final String haystack, final String needle) {


			if(needle.equals("")) return -1;
		    if(haystack.equals("")&&needle.equals(""))return -1;

		    String temp="";

		    int hl = haystack.length();
		    int nl = needle.length();
		    if(nl>hl) return -1;
		    int ret=-1;
	        String wind = haystack.substring(0,nl);
	        pw.println(wind);
	        if(wind.equals(needle)) return 0;

	        for(int i=1;i<hl-nl;i++)
	        {
	            wind = wind.substring(1, wind.length());

	            wind = wind+haystack.charAt(i+nl);

	            pw.println(i+" "+wind);
	            if(wind.equals(needle))
	            {
	                ret=i; break;
	            }

	        }

	        return (ret==-1)?-1:ret;



			}


		public static int diff(String a, String b)
		{
			int ret=0;
			for(int i=0;i<a.length();i++)
			{
				if(a.charAt(i)!=b.charAt(i))ret++;
			}
			return ret;
		}

		public static boolean inter(Vouch a, Vouch b)
		{
			//return true if there's intersection
			int s1 = a.l;
			int e1 = a.r;

			int s2 = b.l;
			int e2 = b.r;

			if(s1<s2)
			{
				if(e1>=s2)return true;
				else return false;
			}
			else if(s1>s2) {
				if(e2>=s1) return true;
				else return false;
			}
			else {
				return true;
			}

		}

		static class Range {
		    int x,y;

		    public Range(int a, int b) {
		        x=a;
		        y=b;
		    }

		}

	}