package algo_28278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		// 입력 시간 줄여주기
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder(); // 출력의 시간을 줄이기 위해 한 번에 출력
		for (int i = 0; i < N; i++) {
			String[] command = bf.readLine().split(" ");
			switch (command[0]) {
				case "1": //"push":
					int X = Integer.parseInt(command[1]);
//					queue.add(X);
					stack.push(X);
					break;
				case "2": //"pop":
//					if (stack.size() == 0) {
					if (stack.isEmpty()) {
						sb.append(-1).append("\n");
						// string builder에 값을 추가해서 최종적으로 그 string 출력
					} else {
						sb.append(stack.poll()).append("\n");
					}
					break;
				case "3": //"size":
					sb.append(stack.size()).append("\n");
					break;
				case "4": //"empty":
					if (stack.size() == 0) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "5": //"peek":
//					if (stack.size() == 0) {
					if (stack.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(stack.peek()).append("\n");
					}
					break;
			}
		}
		System.out.println(sb);
	}
}
