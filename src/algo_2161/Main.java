package algo_2161;
// https://www.acmicpc.net/problem/2161

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 정수 N
		sc.close();
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		while (!queue.isEmpty()) {
			int first = queue.poll();
			System.out.print(first);
			if (queue.isEmpty()) {
				break;
			}
			System.out.print(' ');
			int second = queue.poll();
			queue.add(second);
		}
	}
}

// 풀이용
//public class Main {
//	public static void main(String[] args) {
//		// 입력, 계산, 출력
//		Scanner sc = new Scanner(System.in);
//		// 입력 받는 코드
//		int N = sc.nextInt(); // 정수 N
//		System.out.println(N);
//		sc.close();
//		// 스캐너 반환
//
//		// 계산 시작
//		Queue<Integer> queue = new ArrayDeque<>();
//		// Queue에 인터페이스는 있고, Stack 처럼 구현된것이 없음
//
//		for (int i = 1; i <= N; i++) {
//			// 1부터 시작해서 넣어줘야해서 시작값이 1
//			queue.add(i);
//		}
//		while (!queue.isEmpty()) { // queue 가 비워져있지 않다면 (빌때까지) 반복
//			System.out.println(queue);
//			// 첫 번째 장은 버리고,
//			int first = queue.poll();
//			System.out.println("첫 번째 장 버리기 : " + first);
//			// 마지막 장은 맨 뒤로 보내기 (queue)
//			int second = queue.poll();
//			// 2번째가 비어있어서
//			if(queue.isEmpty()) {
//				break;
//				// None 에러 방지
//			}
//			queue.add(second);
//			System.out.println("두 번째 장 뒤로 보내기 : " + second);
////			System.out.println(queue);
//		}
//
//	}
//}
