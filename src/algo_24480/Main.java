package algo_24480;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int order;
	static int[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 공백으로 끊어진 숫자들
		int M = Integer.parseInt(st.nextToken()); // 공백으로 끊어진 숫자들
		int R = Integer.parseInt(st.nextToken()); // 공백으로 끊어진 숫자들
		for (int n = 0; n < N; n++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 공백으로 끊어진 숫자들
			int v = Integer.parseInt(st.nextToken()); // 공백으로 끊어진 숫자들
			graph.get(u - 1).add(v - 1);
			graph.get(v - 1).add(u - 1);
		}

		for (ArrayList<Integer> g : graph) {
			Collections.sort(g, Comparator.reverseOrder());
		}

		check = new int[N]; // 전체 정점의 갯수만큼
		order = 1; // 첫 방문
		dfs(R-1); // R => 시작 정점 (1을 빼줘야함? -> 인덱스)

		for (int c: check) {
			System.out.println(c);
		}
	}


	private static void dfs(int node) {
		check[node] = order;
		ArrayList<Integer> g = graph.get(node); // 현재 노드와 연결된 간선들
		for (int nextNode : g) {
			if (check[nextNode] == 0) { // 다음 노드가 방문하지 않은 정점이라면
				order++;
				dfs(nextNode);
			}
		}
	}

}