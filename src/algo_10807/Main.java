package algo_10807;

import java.util.Scanner;

// 개수 세기
// https://www.acmicpc.net/problem/10807
public class Main {
	public static void main(String[] args) {
		// 입력 고정
		Scanner sc = new Scanner(System.in);
		// 표준입출력 문제는 입력을 매개변수를 받는게 아니라 직접 Scanner로 받아줘야함
		// 입력: 총 N개의 정수. 정수 v.
		// - 1 : 정수의 개수 (1 ~ 100) -> N
		// - 2 : 정수가 '공백'으로 구분
		// - 2-1 : nextInt로 끊어서 받을 수 있음
		// - 3 : 찾으려는 정수 v
		// 출력: 정수 v가 몇 개인지...
		// 11
		// 1 4 1 2 4 2 4 2 3 4 4
		// 2
		// 첫째 줄 N
		int N = sc.nextInt();
		// System.out.println(N);
		// 둘째 줄 -> 공백으로 구분된 정수
		// -> 위에 있는 N.
		int[] arr = new int[N]; // 0 ~ n-1까지의 인덱스
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt(); // 저장.
			// 이렇게 해두면 sc.nextInt값이 저장이 됩니까?
			// 변수로 가능한가? -> 1부터 100 사이로 변하니까... 처음의 저장하는 위치는 N에 비례해서 변화
		}
		int v = sc.nextInt(); // 3번째 줄 정수 v
		// arr에 저장됨 -> arr를 순회
		// System.out.println("v : " + v);
		int count = 0;
		for (int j = 0; j < N; j++) {
			// arr에 저장되어 있는 값을 바탕으로
			// v와 일치되는 값을 찾으면 되는데...
			// System.out.println(arr[j]);
			if (arr[j] == v) {
				count++;
			}
		}
		// System.out.println("count: " + count);
		System.out.println(count); // 정답제출용 출력
	}
}