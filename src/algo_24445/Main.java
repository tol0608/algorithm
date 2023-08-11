package algo_24445;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;


// 제출용
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

//		System.out.println(graph);

		check = new int[N]; // 전체 정점의 갯수만큼
		order = 1; // 첫 방문

		// BFS
		Queue<Integer> q = new ArrayDeque<>();
		int start = R - 1;
		q.add(start); // 루트 노드 (시작점) - 1부터 => 0부터...
		check[start] = order; // 방문한 시작점에 1번째 방문을 기록
		while (!q.isEmpty()) { // queue가 빌 때까지
			int currentNode = q.poll();
//			System.out.println("현재 노드 : " + currentNode);
			// 가장 오래된 노드를 큐에서 꺼냅니다
			ArrayList<Integer> edges = graph.get(currentNode);
			// 그래프에서 조회해서 그 노드와 연결된 다음 노드들
			for (int nextNode : edges) {
				if (check[nextNode] != 0) {
					continue;
				} // if (check[nextNode] == 0) {}
//				System.out.println("다음 노드 : " + nextNode);
				check[nextNode] = ++order;
				q.add(nextNode);
			}
		}

		for (int c : check) {
			System.out.println(c);
		}
	}

}