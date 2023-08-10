package algo_1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// 제출용
public class Main {

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String line = br.readLine(); // 첫번째 줄
		int N = Integer.parseInt(line.split(" ")[0]);
		int K = Integer.parseInt(line.split(" ")[1]);
		// 계산
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}
		System.out.print("<");
		while (!queue.isEmpty()) { // queue에 사람이 남아 있으면...
			for (int j=1; j <= K; j++) {
				if (j == K) { // 1부터 세서 K가 도달하면...
//					System.out.println(queue.poll()); // 밖으로 내보냄...
					int num = queue.poll();
					if (queue.isEmpty()) {
						System.out.print(num + ">");
					} else {
						System.out.print(num + ", ");
					}

				} else {
					queue.add(queue.poll());
					// K번째가 아닌 사람이라면 뒤로 다시 줄서게하고...
				}
			}
		}
	}

}

// 설명용
//public class Main {
//	public static void main(String[] args) throws IOException {
//		//  입력
//		BufferedReader br = new BufferedReader(
//				new InputStreamReader(System.in));
//		String line = br.readLine(); // 첫 번째 줄
//		int N = Integer.parseInt(line.split(" ")[0]);
//		int K = Integer.parseInt(line.split(" ")[1]);
//		// 계산
//
//		// 사람들 넣기
//		ArrayDeque<Integer> queue = new ArrayDeque<>();
//		for (int i = 0; i < N; i++) {
//			queue.add(i + 1);
//		}
//		System.out.println(queue); // 1, 2, 3, 4, 5, 6, 7
//		while (queue.isEmpty()) {
//			for (int j = 0; j < K; j++) {
//				if (j == K) { // 1부터 세서 K에  도달하면,
//					System.out.println(queue.poll());  // 밖으로 내보냄
//				} else {
//					queue.add(queue.poll()); // K번째 사람이 아니면 뒤에 다시 줄서라고함
//				}
//
//			}
//		}
//
//	}
//}
