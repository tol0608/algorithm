package algo_11651;

import java.util.Arrays;
import java.util.Scanner;

public class Main { // Main으로 고쳐야함 (BOJ)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] pointArr = new int[N][2];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int[] point = new int[2];
			point[0] = x;
			point[1] = y;
			pointArr[i] = point;
		}
		sc.close();
		Arrays.sort(pointArr, (e1, e2) -> {
			if (e1[1] != e2[1]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
		for (int[] point: pointArr) {
			System.out.println(point[0] + " " + point[1]);
		}
	}
}

// 아래는 풀이용
//public class Main {
//	public static void main(String[] args) {
//		//  2차원 평면
//		//  x축, y축 (바둑판, 체스판)
//		//  입력, 계산, 출력
//		//  입력 : N개의 점 (점 -> x좌표, y좌표) => 쌍
//		//  int x, int y => 점 => 배열 int[]
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt(); // 첫번째 등장하는 숫자를 N으로 할당
//		// 점의 갯수 N -> N 만큼 점(x, y쌍)이 존재 -> N번 만큼 반복
//		// [][] -> 2중배열, 2차원 배열 => int.
//		int[][] pointArr = new int[N][2]; // 감싸주는게 먼저 카운트 됨
//		for (int i = 0; i < N; i++) { // N에 비례해서 자동으로 N번 스캔
//			//  점마다의 x, y의 쌍을 받아오는 것
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//			System.out.println("X : " + x + " y : " + y);
//			int[] point = new int[2]; // 2개의 자리
//			point[0] = x;
//			point[1] = y; // 일반적으로 쓰는 좌표는 x, y 순서
//			pointArr[i] = point;
//		}
//		sc.close(); // 반복문 종료후 스캐너 닫아주기
////		System.out.println("pointArr");
////		for (int[] point : pointArr) {
////			System.out.println(point[0] + " " + point[1]);
////		}
//		//  계산 : (1) y좌표가 증가하는 순 (2) x좌표가 증가하는 순
//		// Comparator.reverseOrder() -> 역순 정렬
//		Arrays.sort(pointArr, (e1, e2) -> {
//			// e1, e2 -> point -> 0: x, 1: y
//			// y를 먼저 비교
//			if (e1[1] != e2[1]) { // point e1, e2 => 1(y) 다르
//				return e1[1] - e2[1]; // y끼리의 차이로 정렬
//				// sort -> +면 e1이 뒤로가고 -면 e2가 뒤로가고 0이면 그대로
//			} else {
//				return e1[0] - e2[0];
//			}
//		});
//		// 람다식 -> 1.8 이후에 나온 문법
//		// https://www.w3schools.com/java/java_lambda.asp
//		// 비교의 기준이 되는 메서드가 들어와야함
//		// 메서드를 별도로 지정하지 않고도 넣어주는 방법
//		// 람다식 : (매개변수) -> {메서드의 본문(실행문)}
////		System.out.println("pointArr");
//		for (int[] point : pointArr) {
//			System.out.println(point[0] + " " + point[1]);
//		}
//		//  정렬하는 기준 : y좌표를 먼저 x좌표가 나중에
//		//  증가하는 순 => 오름차순 (인덱스가 증가하는 순)
//	}
//
//}