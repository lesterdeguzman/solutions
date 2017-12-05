import java.io.*;
import java.util.*;

public class SimilarWords
{
	public static HashMap<Long, Integer> map;
	public static HashSet<Integer> adj[];
	static int memo[][];
	public static void main(String[] args)
	{
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int numCases = in.nextInt();
		
		for(int l = 1; l <= numCases; l++)
		{
			int n = in.nextInt();
			map = new HashMap<>();
			String data[] = new String[n];
			int precomp[][] = new int[n][];
			
			for(int i = 0; i < n; i++)
			{
				String s = data[i] = in.next();
				precomp[i] = new int[s.length()];
				RollingHash a = new RollingHash(new int[]{0, 0, 0}, 0);
				
				for(int j = 0; j < s.length(); j++)
				{
					a.add(s.charAt(j)-'a');
					
					if(!map.containsKey(a.hashCode2()))
					{
						precomp[i][j] = map.size();
						map.put(a.hashCode2(), map.size());
					}
					else
						precomp[i][j] = map.get(a.hashCode2());
				}
			}
			
			adj = new HashSet[map.size()];
			for(int i = 0; i < adj.length; i++)
				adj[i] = new HashSet<>();
			
			for(int i = 0; i < n; i++)
			{
				RollingHash b = new RollingHash(new int[]{0, 0, 0}, 0);
				String s = data[i];
				
				for(int j = 1; j < s.length(); j++)
				{
					int v1 = precomp[i][j];
					b.add(s.charAt(j)-'a');
					Integer v2 = map.get(b.hashCode2());
						
					if(v2 != null)
					{
						adj[v1].add(v2);
						adj[v2].add(v1);
					}
				}
			}
			
			memo = new int[adj.length][2];
			for(int a[] : memo) Arrays.fill(a, -1);
			int ans = 0;
			boolean visited[] = new boolean[adj.length];
			for(int i = 0; i < adj.length; i++)
			{
				if(visited[i]) continue;
				ans += go(i, visited, 0, -1);
			}
			
			out.println(ans);
		}
		
		out.close();
	}

	private static int go(int u, boolean[] visited, int flag, int prev)
	{
		visited[u] = true;
		if(memo[u][flag] != -1)
			return memo[u][flag];
		
		int skip = 0;
		int take = 1;
		for(Integer v : adj[u])
		{
			if(v == prev) continue;
			
			skip += go(v, visited, 0, u);
			if(flag == 0)
				take += go(v, visited, 1, u);
		}
		
		int ans = skip;
		if(flag == 0)
			ans = Math.max(take, skip);
		
		return memo[u][flag] = ans;
	}

	public static class RollingHash
	{
		public static final long MODS[] = {(long)1e9+7, (long)1e9+9, 1000037};
		public static final int n = 2;
		long hashes[];
		int size;
		
		public RollingHash(int a[], int s)
		{
			hashes = new long[n];
			size = s;
			
			for(int i = 0; i < n; i++)
				hashes[i] = a[i] % MODS[i];
		}

		public void add(int c)
		{
			c++;
			
			for(int i = 0; i < n; i++)
				hashes[i] = (hashes[i]*31 + c) % MODS[i];
		}
		
//		public int hashCode()
//		{
//			return hashes[0];
//		}
		
		public long hashCode2()
		{
			return hashes[0] * MODS[1] + hashes[1];
		}
		
		public boolean equals(Object obj)
		{
			if(!(obj instanceof RollingHash))
				return false;
			
			RollingHash o = (RollingHash) obj;
			
			for(int i = 0; i < n; i++)
				if(hashes[i] != o.hashes[i])
					return false;
			
			return true;
		}
		
		public String toString()
		{
			return hashes[0] + " " + hashes[1] + " " + hashes[2];
		}
	}
	
	public static class FastScanner
	{
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s)
		{
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public FastScanner()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken()
		{
			while (st == null || !st.hasMoreElements())
			{
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt()
		{
			return Integer.parseInt(nextToken());
		}

		long nextLong()
		{
			return Long.parseLong(nextToken());
		}

		double nextDouble()
		{
			return Double.parseDouble(nextToken());
		}
		
		String next()
		{
			return nextToken();
		}
	}
}