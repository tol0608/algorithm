package algo_16194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 카드팩의 종류별로 '가격'
		// N개의 카드를 구매하기 위한 최소가격
		// 2개 -> 1개 => 2번 구매
		// 3개 -> 1개 + 2개를 구매했을...
		// N개 -> N-1개 + 1개.

		// 카드 N개를 구매한다
		// 카드 1개 + 카드 N-1개...
		// 카드 2개 + 카드 N-2개...
		// 중간값까지 반복...
		// 팩가격[n] -> n개를 구매했을 때의 가격 (price)
		// 지불액[N] = 팩가격[n] + 지불액[N-n] (dp)
		// 팩가격[n] + 지불액[N-n] => 이 가능한 조합중에 가장 작은 값 => 최소지불액
		// 최소값 -> 구할 수 있는 모든 조합을 구해서...
		// 그중에 최소값 -> 재귀적으로 풀면 연산이 너무 많아짐
		// 메모이제이션(DP)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println("구매하려고 하는 카드 수 N : " + N);
		// P -> 팩의 갯수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] price = new int[N + 1]; // 각 카드팩을 개별적으로 샀을 경우 가격
		int[] dp = new int[N + 1]; // 카드를 N개 구매했을 경우의 최저가
		for (int i = 0; i < N; i++) {
			// 토큰 개수만큼 반복 (N이랑 같음)
			price[i + 1] = Integer.parseInt(st.nextToken());
			// int 범위를 벗어나지 않으므로
			dp[i + 1] = Integer.MAX_VALUE; // Integer 범위에서 가장 큰 값
		}
		System.out.println("Price");
		for (int p : price) { // price 배열 확인용
			System.out.print(p + " ");
		}
		System.out.println();
		System.out.println("DP (최소값)");
		for (int p : dp) { // dp 배열 확인용
			System.out.print(p + " ");
		}
		System.out.println();
		// 로직은 생각보다 간단합니다!
		for (int i = 1; i <= N; i++) { // N+1 -> N까지 돌려줘야함
			// 지불액[N] = 팩가격[n] + 지불액[N-n]
			// 지불액[10]
			// => 팩가격[10] + 지불액[0] (기존에 저장된 지불액을 쓰지 않고 다 팩으로 때우는 경우)
			// => 팩가격[9] + 지불액[1]
			// => ...
			// => 팩가격[1] + 지불액[9] (팩은 하나사고, 그 직전 지불액까지를 다 쓰는 경우)
			// => 지금까지 이 경우의 수 중에 '최소값' => 지불액[10]
			// 지불액[11] -> 이전까지의 과정을 반복.
			for (int j = 1; j <= i; j++) {
				// i번째 -> i개의 팩을 구매하는 방법
				// dp[i] => 처음에는 Integer.MAX. (무엇이랑 비교하든 이쪽이 큼)
				// dp[i - 1] (직전 풀이) + price[1] -> 1개를 샀을 때
				// dp[i - 1] + price[1]
				// dp[i - 1] + price[1] vs dp[i - 2] + price[2]
				// 이중에 최소값 -> dp[i] => i번 (내가 이번에 사려고 한 카드팩의 갯수)
				dp[i] = Math.min(dp[i], dp[i - j] + price[j]);
			}
			// i의 다음번째 순번 => 1이라면, i = 2번째 순번을 맞이하고, dp[1]을 갖고 시작.
			System.out.println("DP (최소값) : " + i);
			for (int p : dp) { // dp 배열 확인용
				System.out.print(p + " ");
			}
			System.out.println();
		}

	}
}

// 제춣용
//      import java.io.BufferedReader;
//		import java.io.IOException;
//		import java.io.InputStreamReader;
//		import java.util.StringTokenizer;
//
//public class Main {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int[] price = new int[N+1]; // 각 카드팩을 개별적으로 샀을 경우 가격
//		int[] dp = new int[N+1]; // 카드를 N개 구매했을 경우의 최저가
//		for (int i = 0; i < N; i++) {
//			price[i+1] = Integer.parseInt(st.nextToken());
//			dp[i+1] = Integer.MAX_VALUE; // Integer 범위에서 가장 큰 값
//		}
//		for (int i = 1; i <= N; i++) { // N+1 -> N까지 돌려줘야함
//			for (int j = 1; j <= i; j++) {
//				dp[i] = Math.min(dp[i], dp[i - j] + price[j]);
//			}
//		}
//		System.out.println(dp[N]);
//	}
//}
