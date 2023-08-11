package algo_12945;

public class Main {
	public static void main(String[] args) {

	}

	public int solution(int n) {
		int answer = f(n);
		return answer % 1234567; // 나머지 연산자
	}

	public int f(int n) {
		if (n == 0) {
			return 0;
			// F(0) = 0
		}
		if (n == 1) {
			return 1;
			// F(1) = 1
		}
		// return f(n-2) + f(n-1);
		return (f(n - 2) + f(n - 1)) % 1234567;
		// 실은 상단의 값이 큼
	}

// 재귀함수로 해결
//	class Solution {
//		public int solution(int n) {
//			int answer = f(n);
//			return answer % 1234567; // 나머지 연산자
//		}
//
//		public int f(int n) {
//			if (n == 0) {
//				return 0;
//				// F(0) = 0
//			}
//			if (n == 1) {
//				return 1;
//				// F(1) = 1
//			}
//			// return f(n-2) + f(n-1);
//			return (f(n-2) + f(n-1)) % 1234567;
//			// 실은 상단의 값이 큼
//		}
//	}

// 메모라이제이션으로 해결
//	class Solution {
//		public int solution(int n) {
//			// F(0) -> 0
//			// F(1) -> 1
//			// F(2) -> F(0) + F(1) => 인덱스?
//			// F(3) -> F(1) + F(2)
//			int[] memo = new int[n+1]; // 입력을 받아주는 n+1(끝 인덱스가 n이 되는 배열)
//			for (int i = 0; i <= n; i++) {
//				if (i == 0 || i == 1) {
//					memo[i] = i; // 0이거나 1이면
//				} else {
//					int sum = memo[i - 2] + memo[i - 1];
//					memo[i] = sum % 1234567;
//				}
//			}
//			return memo[n]; // 0 ~ n (n-1 => n)
//		}
//
//	}

}
