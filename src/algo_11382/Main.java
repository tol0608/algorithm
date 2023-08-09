package algo_11382;

class Solution {
	public int[] solution(int[] arr) {
		if (arr.length == 1) {
			return new int[]{-1};
		}

		int min = Integer.MAX_VALUE;
		for (int num : arr) {
			if (min > num) {
				min = num;
			}
		}

		int[] newArr = new int[arr.length - 1];
		int index = 0;
		for (int a : arr) {
			if (a != min) {
				newArr[index++] = a;
			}
		}

		return newArr;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();

		// 테스트 배열
		int[] arr = {4, 3, 2, 1, 5};

		// solution 함수 호출
		int[] result = solution.solution(arr);

		// 결과 출력
		if (result.length == 1 && result[0] == -1) {
			System.out.println("빈 배열입니다.");
		} else {
			System.out.print("가장 작은 수를 제외한 배열: ");
			for (int num : result) {
				System.out.print(num + " ");
			}
		}
	}
}

//class Solution {
//	// 1. 배열
//	public int[] solution(int[] arr) {
//		// 리턴하려는 배열이 빈 배열인 경우 -> 배열 내부에 원소가 1개만 있다면,
//		// 가장 작은 수를 제거했을 경우 갯수가? 0개다 - 빈 배열이 된다
//		// arr은 길이가 1 이상인 배열
//		if (arr.length == 1) { // 전달받은 arr의 길이가 1이라면
//			// 빈 배열이 될 예정이기 때문에... (가장 작은 수를 빼면...)
//			return new int[] {-1};
//		}
//		// 가장 작은 수를 찾아서, 제외를 해줄 건데...
//		int min = Integer.MAX_VALUE; // int 중에서 가장 큰 값
//		for (int num : arr) {
//			// min과 num을 최초로 비교하면...? -> num
//			// System.out.println(num);
//			// System.out.println(min + " " + num);
//			// num이 더 작을 때 min에 할당해줘야하는데...
//			if (min > num) { // 직전까지의 최소값이 num보다 크다면...
//				min = num; // num을 min에 할당(대입)
//			}
//		}
//		// System.out.println("최소값 : " + min);
//		int[] newArr = new int[arr.length - 1]; // 가장 작은 수 (1개)를 뺀 배열
//		// 다시 한 번...
//		int index = 0; // 새로운 배열의 원소 할당을 위한 인덱스
//		for (int a : arr) { // min. -> min이 아닌...
//			// System.out.println(index + " " + a);
//			if (a == min) {
//				// System.out.println(a + "는 최솟값이다!");
//				// 최소값일 경우에는 index++ 이 작동하지 않아서
//				// 해당 인덱스는 다음에 다시 사용되게 됨
//			} else {
//				newArr[index++] = a; // 값을 할당하고 나서 index++.
//			}
//		}
//		// int[] answer = {};
//		// return answer;
//		return newArr;
//	}
//}
