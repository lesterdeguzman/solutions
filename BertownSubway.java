import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BertownSubway {
	private static int[] array;
	private static boolean[] visited;
	private static ArrayList<Integer> components = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(f.readLine());
		array = new int[N];
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(f.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i])
				dfs(i);
		}
		Collections.sort(components);
		int size = components.size();
		long result = 0L;
		if (size != 1) {
			int[] results = new int[size - 1];
			for (int i = 0; i < size - 2; i++) {
				results[i] = components.get(i);
			}
			results[size - 2] = components.get(size - 2) + components.get(size - 1);
			for (int i : results) {
				result += (long) i * (long) i;
			}
		} else {
			result = (long) components.get(0) * (long) components.get(0);
		}
		System.out.println(result);
	}

	public static void dfs(int start) {
		int index = start;
		int count = 0;
		while (true) {
			count++;
			visited[index] = true;
			int next = array[index];
			if (next == start)
				break;
			index = next;
		}
		components.add(count);
	}

	public static void printArray(int[] array) {
		for (int i : array)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void printArrayListInteger(ArrayList<Integer> array) {
		for (int i : array)
			System.out.print(i + " ");
		System.out.println();
	}
}