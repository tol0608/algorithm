package algo_42748;

import java.util.Arrays;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int a = 0; a < commands.length; a++) {
			int[] command = commands[a];
			int i = command[0];
			int j = command[1];
			int k = command[2];

			int[] newArray = new int[j - i + 1];
			int index = 0;
			for (int b = i - 1; b < j; b++) {
				newArray[index++] = array[b];
			}

			Arrays.sort(newArray);

			int value = newArray[k - 1];
			answer[a] = value;
		}

		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

		int[] result = solution.solution(array, commands);

		System.out.println("Result:");
		for (int value : result) {
			System.out.print(value + " ");
		}
	}
}


//class Solution {
//	public int[] solution(int[] array, int[][] commands) {
//		// 입력 : array
//		// 입력2 : i~j번째. k번째의 수. -> commands int[][]
//		//         -> command int[] -> [i, j, k]
//		// i, j, k도 인덱스가 아니라... 일반적인 수. (1부터 시작)
//		// 배열을 <정렬>하면 -> 2, 3, 5, 6
//		// 크기 순서대로 줄을 세우는 것.
//		// 아이폰11, 아이폰4, 아이폰6... -> 정렬
//		// (1) 어떠한 크기를 기준으로 삼을 것인가? => 넘버링.
//		// (2) 그 크기를 어떠한 방향으로 정리할 것인가?
//		// 아이폰11, 아이폰6, 아이폰4? or 아이폰4, 아이폰6, 아이폰11
//		// 1/ 어떠한 기준이 정렬 기준이지?
//		// 2/ 그 기준으로 어느 방향으로 줄세울거지? (작은순, 큰순?)
//		// (1) 배열이 있다 -> 배열의 정렬 기준 -> 그 자체의 값
//		// => 어느값이 더 큰건데? 김자바, 이몽룡. => 김 과 이 숫자로 비교X.
//		// 일반적 숫자 기준으로 비교를 못할 경우에... => 한글(가나다)
//		// (2) 어느 방향으로 줄세울거지?
//		// - 1. 작은 값이 먼저 오고 큰 값이 뒤로 온다 (올라간다->오름차순)
//		// -> ascending (승천, 상승...) **
//		// - 2. 큰 값이 먼저 오고 작은 값이 뒤로 온다 (내려간다->내림차순)
//		// -> descending
//
//		// 반복문 -> commands (i, j, k)
//		// commands -> 반복을 진행할 때 -> 그 결과물이 배열로 담겨야해요
//		int[] answer = new int[commands.length]; // commands의 command가 한 번씩 반복 될 때마다 -> 이 answer에 결과값을 추가
//		for (int a = 0; a < commands.length; a++) {
//			int[] command = commands[a]; // 원소 -> i, j, k (0, 1, 2)
//			int i = command[0];
//			System.out.println("i :" + i); // 일반적인 숫자체계
//			// -> 배열? => 컴퓨터의 숫자체계 (0부터 시작)
//			int j = command[1];
//			System.out.println("j :" + j);
//			int k = command[2];
//			System.out.println("k :" + k);
//			// i번째부터 j번째까지 자르면 -> j-i + 1 개. (i <= j)
//			// 2번째 ~ 5번째... 2, 3, 4, 5 (4개)
//			// 동일했을 때 남는 나 자신 (1개)가 더해지는 개념
//			int[] newArray = new int[j - i + 1]; // 산출된 개수!!
//			// 문제에서 수학적으로 파악하던가, 풀어보면서 조정해나가던가...
//			int index = 0; // newArray에 새로운 값을 넣어주기 위한 인덱스
//			// -------
//			// 1) i와 j를 그대로 두고, array에서 인덱스로 조회할 때 1 빼주기
//			// for (int b = i; b <= j; b++) { // i, j가 컴퓨터의 수 X
//			//     // index가 0번째를 지정을 하되... 다음 반복에서는 +1
//			//     newArray[index++] = array[b - 1]; // 1씩 빼서 생각
//			// }
//			// -------
//			// 2) 아예 반복문 할 때 앞뒤로 1씩 빼서... 반복문 자체를 단순화
//			for (int b = i - 1; b < j; b++) { // i, j가 컴퓨터의 수 X
//				// index가 0번째를 지정을 하되... 다음 반복에서는 +1
//				newArray[index++] = array[b]; // 이것도 맞음!
//			}
//			// i -> 0번째 b-1 째가 끝인 새로운 배열 newArray
//			System.out.println("**newArray**");
//			for (int n : newArray) {
//				System.out.println(n);
//			}
//			System.out.println("**정렬**");
//			Arrays.sort(newArray); // Arrays -> 배열 관련된 유용한 메소드
//			// sort (정렬하다) -> 매개변수로 array를 넣으면... 해당 정렬.
//			// 원본이 변해버림!
//			// Arrays.sort -> 오름차순으로 (들어간 원소의 값에 따라) 자동 정렬 (??? : 내림차순)
//			for (int n : newArray) {
//				System.out.println(n);
//			} // 오름차순의 정렬 상태 : newArray
//			// 이 newArray에서 k번째를... 추출해주는 것.
//			int value = newArray[k - 1];
//			System.out.println("k번째수 : " + value);
//			// a -> command의 인덱스
//			answer[a] = value;
//		}
//
//		// command의 모든 원소 (command)에 대해 연산을 처리한 값
//		// int[] answer = {};
//		return answer;
//	}
//}