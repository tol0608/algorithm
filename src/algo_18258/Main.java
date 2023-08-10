package algo_18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


// https://www.acmicpc.net/problem/18258

// 정답 (입력&출력 시간 줄이기)
public class Main {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		// 입력 시간 줄여주기
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(sc.nextLine());
		int N = Integer.parseInt(bf.readLine());
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder(); // 출력의 시간을 줄이기 위해 한 번에 출력
		for (int i = 0; i < N; i++) {
//			String command = sc.nextLine();
//			String[] command = sc.nextLine().split(" ");
			String[] command = bf.readLine().split(" ");
//			if (command.startsWith("push")) {
//				String[] pushCommand = command.split(" ");
//				int X = Integer.parseInt(pushCommand[1]);
//				queue.add(X);
//			} else {
//			sb.append(command[0]);
			switch (command[0]) {
				case "push":
					int X = Integer.parseInt(command[1]);
					queue.add(X);
					break;
				case "pop":
					if (queue.size() == 0) {
//					System.out.println(-1); // println이 생각보다 시간을 많이 잡아먹음
						sb.append(-1).append("\n"); // string builder에 값을 추가해서 최종적으로 그 string 출력
					} else {
//					System.out.println(queue.poll());
						sb.append(queue.poll()).append("\n");
					}
					break;
				case "size":
//				System.out.println(queue.size());
					sb.append(queue.size()).append("\n");
					break;
				case "empty":
					if (queue.size() == 0) {
//					System.out.println(1);
						sb.append(1).append("\n");
					} else {
//					System.out.println(0);
						sb.append(0).append("\n");
					}
					break;
				case "front":
					if (queue.size() == 0) {
//					System.out.println(-1);
						sb.append(-1).append("\n");
					} else {
//					System.out.println(queue.peek());
						sb.append(queue.peek()).append("\n");
					}
					break;
				case "back":
					if (queue.size() == 0) {
//					System.out.println(-1);
						sb.append(-1).append("\n");
					} else {
//					System.out.println(queue.peekLast());
						sb.append(queue.peekLast()).append("\n");
					}
					break;
			}
//			}
		}
//		sc.close();
		System.out.print(sb);
	}

}

// 풀이용
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = Integer.parseInt(sc.nextLine());
//		ArrayDeque<Integer> queue = new ArrayDeque<>();
//		for (int i = 0; i < N; i++) {
//			String command = sc.nextLine();
//			if (command.startsWith("push")) {
//				String[] pushCommand = command.split(" ");
//				int X = Integer.parseInt(pushCommand[1]);
//				queue.add(X);
//			} else {
//				switch (command) {
//					case "pop":
//						if (queue.size() == 0) {
//							System.out.println(-1);
//						} else {
//							System.out.println(queue.poll());
//						}
//						break;
//					case "size":
//						System.out.println(queue.size());
//						break;
//					case "empty":
//						if (queue.size() == 0) {
//							System.out.println(1);
//						} else {
//							System.out.println(0);
//						}
//						break;
//					case "front":
//						if (queue.size() == 0) {
//							System.out.println(-1);
//						} else {
//							System.out.println(queue.peek());
//						}
//						break;
//					case "back":
//						if (queue.size() == 0) {
//							System.out.println(-1);
//						} else {
//							System.out.println(queue.peekLast());
//						}
//						break;
//				}
//			}
//		}
//		sc.close();
//	}
//
//}

// 정리용
//public class Main {
//	public static void main(String[] args) {
//		// 입력
//		Scanner sc = new Scanner(System.in);
//		// 명령의 수 N
//		// int N = sc.nextInt(); // 줄 바꿈이 안됨
//		int N = Integer.parseInt(sc.nextLine());
//		// 명령이 몇 개인지 -> 반복의 기준
//		// -> 명령과 필요하다면 값. (반복문)
//		ArrayDeque<Integer> queue = new ArrayDeque<>();
//		for (int i = 0; i < N; i++) {
//			String command = sc.nextLine();
//			if (command.startsWith("push")) {
//				// command라는 문자열이 push로 시작하는지 여부를 체크해서
//				System.out.println("push임!");
//				String[] pushCommand = command.split(" ");
//				// " "(공백)을 기준으로 String배열로 변환(구분)
//				int X = Integer.parseInt(pushCommand[1]);
//				// index 1번째가 숫자일 것이므로, 숫자로 변환
//				System.out.println(X);
//				// push X (큐에 넣는 연산)
//				queue.add(X);
//			} else {
//				System.out.println("push 아님!");
//				switch (command) {
//					case "pop": // pop (정수를 출력하는 연산, 없으면 -1)
//						// 없다는 것은? queue가 비었다
//						if (queue.size() == 0) {
//							System.out.println(-1);
//						} else {
//							System.out.println(queue.poll());
//						}
//						break;
//					case "size": // size (개수를 출력)
//						System.out.println(queue.size());
//						break;
//					case "empty": // empty (비어있는지 여부 -> 1)
//						if (queue.size() == 0) {
//							System.out.println(1);
//						} else {
//							System.out.println(0);
//						}
//						break;
//					case "front": // front (가장 앞에 있는 정수 - peek)
//						if (queue.size() == 0) {
//							System.out.println(-1);
//						} else {
//							System.out.println(queue.peek());
//						}
//						break;
//					case "back": // back (가장 뒤에 있는 정수)
//						if (queue.size() == 0) {
//							System.out.println(-1);
//						} else {
//							System.out.println(queue.peekLast());
//						}
//						break;
//				}
//			}
//			System.out.println(command);
//			System.out.println(queue);
//		} // ctrl + shift + f : 줄맞춤
//		sc.close();
//		// 계산
//
//		// 출력
//	}
//}
