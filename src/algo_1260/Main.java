package algo_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 입력 (빠른입력)
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		// 첫번째 라인 -> N, M, V
		// N : 정점의 개수, M : 간선의 개수, V : 루트 노드
		// 4, 5, 1
//		System.out.println(br.readLine());
		// IO 에러가 날 수 있어서
		// throws Exception...
		// 한 줄 자체를 String으로 받아옴
		// String을 쪼개주려면? split -> StringTokenizer
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		System.out.println("정점의 개수 N : " + N);
		System.out.println("간선의 개수 M : " + M);
		System.out.println("루트 노드 V : " + V);

		// 그래프의 간선 연결을 나타내는 이중 배열
//		int[][] graph = new int[N][N]; // 정점의 개수만큼
		graph = new int[N][N]; // 정점의 개수만큼
		// 서로 연결될 가능성 -> N^2
		// 정점 간의 연결을 표시
		for (int i = 0; i < M; i++) { // 간선의 개수만큼 반복
			st = new StringTokenizer(br.readLine());
			// 간선의 데이터 (1 2) 형태를 읽어주는 입력
			// 1 2 -> a b
			int a = Integer.parseInt(st.nextToken());
			// 시작점
			int b = Integer.parseInt(st.nextToken());
			// 끝점
			System.out.println("a = " + a + " b = " + b);
			// 현재 표현된 간선의 데이터는 1부터 시작해서 N까지의 정점들 간의 연결
			// 배열, 리스트 -> 인덱스 0 -> a,b에 1씩 빼서 graph 배열에 저장
			graph[a-1][b-1] = 1; // a와 b에 연결(간선)이 존재한다
			graph[b-1][a-1] = 1; // b와 a에 연결(간선)이 존재한다
			// 간선은 양방향이라 모두한테 추가
		}
		for (int[] g1 : graph) {
			for (int g2 : g1) {
				System.out.print(g2 + " ");
			}
			System.out.println();
		}
		/*
			0 1 1 1 : 0 인덱스 정점이, 1.2.3 인덱스의 정점과 연결이 있다
			1 0 0 1
			1 0 0 1
			1 1 1 0
		 */
		// dfs한 결과 혹은 bfs한 결과를...
		// 정점(노드)별 방문 여부를 나타내는 배열
//		int[] visit = new int[N]; // 정점의 수만큼 방문을 나타내는 배열
		visit = new int[N]; // 정점의 수만큼 방문을 나타내는 배열
		sb = new StringBuilder(); // 방문한 노드들
//		dfs(V-1); // V-1이 되어야함 (일반 숫자 -> 인덱스)
		dfs2(V-1);
		System.out.println(sb); // 1 2 4 3 (DFS 방문)
		visit = new int[N]; // 정점의 수만큼 방문을 나타내는 배열
		sb = new StringBuilder(); // 방문한 노드들
		bfs(V-1);
		System.out.println(sb); // 1 2 3 4 (BFS 방문)
	}

	// 재귀함수 방식으로 할 거면, 매개변수로 계속 주는 것보다 멤버변수화 시키는게 편함
	// 왜 static? -> Main 메서드가 포함된 static 클래스에서 실행하고 있기 때문에...
	static int[] visit;
	static int[][] graph;
	static StringBuilder sb;

	static void dfs(int node) { // 이제 dfs를 통해서 방문한 노드
		// [재귀함수 방식]
		// 방문한 정점 -> 방문 체크
		visit[node] = 1; // 0 -> 방문 안했다 (초기값-빈 int배열을 만들면 0으로 가득 차있음)
		System.out.println("현재 방문한 정점 : " + (node + 1)); // 값을 표시할 때는 1씩 더해서 표시해줌
		sb.append(node + 1);
		sb.append(' ');
		// 다음에 무엇을 방문할까요?
		// -> 현재 방문한 정점과 연결된 정점(간선을 가지고 있는 정점) 중에
		// -> 방문되지 않은 -> visit[node]가 0인 -> 방문 (dfs로 호출)
		for (int i = 0; i < graph[node].length; i++) { // 그래프 배열을 탐색해서
			if (graph[node][i] == 1 && visit[i] == 0) {
				// 1. 간선이 존재하고 (graph[node][i] == 1)
				// 2. 다음 이동할 정점이 방문이 되지 않을 경우 (visit[i] == 0)
				dfs(i); // 인덱스가 곧 정점 이름과 매치되어 있음 -> 어떤 조건에서 dfs
			}
		}
	}

	static void dfs2(int node) { // 스택 방식으로 처리
		// 스택 -> 스택을 통해서...
		Stack<Integer> stack = new Stack<>(); // 탐색할 노드들을 반복적으로 여기에 추가...
		// 가장 최근에 들어간 노드를 자동으로 먼저 뽑아줌 = DFS와 동일
		// 맨 처음 탐색할 정점(노드)을 stack에 추가
		stack.push(node);
		while (!stack.isEmpty()) { // stack이 비어있지 않다면 계속 진행
			// 스택에서 하나를 뽑습니다
			int nextNode = stack.pop();
			if (visit[nextNode] == 1) {
				continue; // 이미 방문된 노드라면 다음 노드로...
				// 탐색하면 안되는 조건 (1)
			} else {
				visit[nextNode] = 1; // 신규 방문이라면 1을 표시
			}
			System.out.println("현재 방문한 정점 : " + (nextNode + 1)); // 값을 표시할 때는 1씩 더해서 표시해줌
			sb.append(nextNode + 1);
			sb.append(' ');
			// i가 작은 순으로 추가
//			for (int i = 0; i < graph[nextNode].length; i++) { // 그래프 배열을 탐색해서
			for (int i = graph[nextNode].length - 1; i >= 0; i--) { // 그래프 배열을 탐색해서
				// -> 이 형태로 가면 큰 수가 나중에 추가 되기 때문에... 해당 큰 수를 먼저 탐색
				// ??? -> 다음 탐색할 노드들을 추가해주는 작업
				// 이미 방문된 노드를 걸러내는 방법 1: -> 재귀에서 했던 것처럼 => 추가할 때 걸러내주거나
				// 2: 방문할 때 걸러내주는 것.
				// !!! : 간선 존재 여부를 생각해줘야함
				if (graph[nextNode][i] == 0) { // 탐색하면 안되는 조건 (2)
					continue; // 간선이 존재하지 않는 경우에 대해서 continue;
				}
				stack.push(i); // 다음 간선으로 연결되어 있는 노드들을 일괄 추가해주고...
			}
		}
	}

	static void bfs(int node) { // 큐 방식으로 처리
		// 큐로 자료구조만 바꿔주면 됨.
		Queue<Integer> queue = new ArrayDeque<>(); // 탐색할 노드들을 반복적으로 여기에 추가...
		// 가장 최근에 들어간 노드를 자동으로 먼저 뽑아줌 = DFS와 동일
		// 맨 처음 탐색할 정점(노드)을 stack에 추가
//		stack.push(node);
		queue.add(node);
//		while (!stack.isEmpty()) { // stack이 비어있지 않다면 계속 진행
		while (!queue.isEmpty()) { // Queue가 비어있지 않다면 계속 진행
			// 큐에서 하나를 뽑습니다
//			int nextNode = stack.pop(); -> pop : 후입선출
			int nextNode = queue.poll(); // 얘가 핵심! -> 선입선출 (같은 레벨의 이전 노드들을 우선탐색)
			if (visit[nextNode] == 1) {
				continue; // 이미 방문된 노드라면 다음 노드로...
				// 탐색하면 안되는 조건 (1)
			} else {
				visit[nextNode] = 1; // 신규 방문이라면 1을 표시
			}
			System.out.println("현재 방문한 정점 : " + (nextNode + 1)); // 값을 표시할 때는 1씩 더해서 표시해줌
			sb.append(nextNode + 1);
			sb.append(' ');
			// i가 작은 순으로 추가
			for (int i = 0; i < graph[nextNode].length; i++) { // 그래프 배열을 탐색해서
				// Queue로 할 때는 작은 인덱스가 순서대로 추가될 수 있게...
				// -> 이 형태로 가면 큰 수가 나중에 추가 되기 때문에... 해당 큰 수를 먼저 탐색
				// ??? -> 다음 탐색할 노드들을 추가해주는 작업
				// 이미 방문된 노드를 걸러내는 방법 1: -> 재귀에서 했던 것처럼 => 추가할 때 걸러내주거나
				// 2: 방문할 때 걸러내주는 것.
				// !!! : 간선 존재 여부를 생각해줘야함
				if (graph[nextNode][i] == 0) { // 탐색하면 안되는 조건 (2)
					continue; // 간선이 존재하지 않는 경우에 대해서 continue;
				}
//				stack.push(i); // 다음 간선으로 연결되어 있는 노드들을 일괄 추가해주고...
				queue.add(i); // 큐 방식으로 변환
			}
		}
	}
}

// 제출용


//import java.io.BufferedReader;
//		import java.io.InputStreamReader;
//		import java.util.ArrayDeque;
//		import java.util.Queue;
//		import java.util.Stack;
//		import java.util.StringTokenizer;
//
//public class Main {
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(
//				new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int V = Integer.parseInt(st.nextToken());
//
//		graph = new int[N][N]; // 정점의 개수만큼
//
//		for (int i = 0; i < M; i++) { // 간선의 개수만큼 반복
//			st = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			graph[a-1][b-1] = 1; // a와 b에 연결(간선)이 존재한다
//			graph[b-1][a-1] = 1; // b와 a에 연결(간선)이 존재한다
//		}
//		visit = new int[N]; // 정점의 수만큼 방문을 나타내는 배열
//		sb = new StringBuilder(); // 방문한 노드들
////		dfs(V-1); // V-1이 되어야함 (일반 숫자 -> 인덱스)
//		dfs2(V-1);
//		System.out.println(sb); // 1 2 4 3 (DFS 방문)
//		visit = new int[N]; // 정점의 수만큼 방문을 나타내는 배열
//		sb = new StringBuilder(); // 방문한 노드들
//		bfs(V-1);
//		System.out.println(sb); // 1 2 3 4 (BFS 방문)
//	}
//
//	static int[] visit;
//	static int[][] graph;
//	static StringBuilder sb;
//
//	static void dfs(int node) { // 이제 dfs를 통해서 방문한 노드
//		visit[node] = 1; // 0 -> 방문 안했다 (초기값-빈 int배열을 만들면 0으로 가득 차있음)
//		sb.append(node + 1);
//		sb.append(' ');
//		for (int i = 0; i < graph[node].length; i++) { // 그래프 배열을 탐색해서
//			if (graph[node][i] == 1 && visit[i] == 0) {
//				dfs(i); // 인덱스가 곧 정점 이름과 매치되어 있음 -> 어떤 조건에서 dfs
//			}
//		}
//	}
//
//	static void dfs2(int node) { // 스택 방식으로 처리
//		Stack<Integer> stack = new Stack<>(); // 탐색할 노드들을 반복적으로 여기에 추가...
//		stack.push(node);
//		while (!stack.isEmpty()) { // stack이 비어있지 않다면 계속 진행
//			int nextNode = stack.pop();
//			if (visit[nextNode] == 1) {
//				continue; // 이미 방문된 노드라면 다음 노드로...
//			} else {
//				visit[nextNode] = 1; // 신규 방문이라면 1을 표시
//			}
//			sb.append(nextNode + 1);
//			sb.append(' ');
//			for (int i = graph[nextNode].length - 1; i >= 0; i--) { // 그래프 배열을 탐색해서
//				if (graph[nextNode][i] == 0) { // 탐색하면 안되는 조건 (2)
//					continue; // 간선이 존재하지 않는 경우에 대해서 continue;
//				}
//				stack.push(i); // 다음 간선으로 연결되어 있는 노드들을 일괄 추가해주고...
//			}
//		}
//	}
//
//	static void bfs(int node) { // 큐 방식으로 처리
//		Queue<Integer> queue = new ArrayDeque<>(); // 탐색할 노드들을 반복적으로 여기에 추가...
//		queue.add(node);
//		while (!queue.isEmpty()) { // Queue가 비어있지 않다면 계속 진행
//			int nextNode = queue.poll(); // 얘가 핵심! -> 선입선출 (같은 레벨의 이전 노드들을 우선탐색)
//			if (visit[nextNode] == 1) {
//				continue; // 이미 방문된 노드라면 다음 노드로...
//			} else {
//				visit[nextNode] = 1; // 신규 방문이라면 1을 표시
//			}
//			sb.append(nextNode + 1);
//			sb.append(' ');
//			for (int i = 0; i < graph[nextNode].length; i++) { // 그래프 배열을 탐색해서
//				if (graph[nextNode][i] == 0) { // 탐색하면 안되는 조건 (2)
//					continue; // 간선이 존재하지 않는 경우에 대해서 continue;
//				}
//				queue.add(i); // 큐 방식으로 변환
//			}
//		}
//	}
//}