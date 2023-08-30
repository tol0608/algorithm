package algo_9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		/*
3
4
7
10
		 */
		// 첫째줄 T
		// 각 테스트케이스는 1 ~ 10 사이의 정수 n
		// -> n을 1, 2, 3의 합으로 나타내는 방법의 수 => 순서가 다르면 다른 방법
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		System.out.println(String.format("테스트 케이스의 수 : %d", T)); // %d <- T
		// printf -> \n 넣어줘야함 (개인적으로 불호...)
		// 테스트 케이스만큼 반복해줘야함
		int[] dp = new int[11]; // 인덱스는 0부터 시작이라... 차라리 공간을 하나 더 두기
		// dp를 외부에서 공유함 (1~10 사이의 n이 무지막지하게 들어올 예정)
		// ...
		// 1 => {1} 1은 딱 하나의 방법인데
		// 2 => {1+1, 2} 2부터는 무언가 분기 생기기 시작...
		// 3 => {1+1+1, 1+2, 2+1, 3} // 순서가 바뀌면 다른 값
		// 4 => {1+3}, {2+2}, {3+1} => 4부터는 1과 2와 3의 관계로...
		//   => 2는 {1+1, 2} 방법, 3은 {...} 방법.
		//   => 1을 만드는 방법 + 2를 만드는 방법 + 3을 만드는 방법
		// 5 => {2+3}, {1+4}, {4+1}, {3+2}
		//   => 2를 만드는 방법 + 3을 만드는 방법 + 4를 만드는 방법...
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int j = 4; j <= 10; j++) {
			dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1]; // 4 = 1, 2, 3 // 점화식
		}
		for (int i = 0; i < T; i++) {
			// n은 테스트케이스만큼 등장함
			int n = Integer.parseInt(br.readLine());
			System.out.println(String.format("입력받은 n : %d", n)); // %d <- n
			System.out.println(dp[n]);
		}
	}
// 효율성 통과
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		int[] dp = new int[11]; // 인덱스는 0부터 시작이라... 차라리 공간을 하나 더 두기
//		dp[1] = 1;
//		dp[2] = 2;
//		dp[3] = 4;
//		for (int j=4; j<=10; j++) {
//			dp[j] = dp[j-3] + dp[j-2] + dp[j-1]; // 4 = 1, 2, 3 // 점화식
//		}
//		for (int i = 0; i < T; i++) {
//			int n = Integer.parseInt(br.readLine());
//			System.out.println(dp[n]);
//		}
//	}
}
