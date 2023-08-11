package algo_43165;

class Solution {
	int answer = 0;
	int target;
	int[] numbers;

	public int solution(int[] numbers, int target) {
		this.target = target;
		this.numbers = numbers;
		dfs(0, 0);
		return answer;
	}

	public void dfs(int depth, int sum) {
		if (depth < numbers.length) {
			dfs(depth + 1, sum + numbers[depth]);
			dfs(depth + 1, sum - numbers[depth]);
		} else {
			if (sum == target) {
				answer++;
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		int result = solution.solution(numbers, target);
		System.out.println("Answer: " + result); // 예상되는 답 출력
	}
}


//제출용
//class Solution {
//	int answer = 0; // 멤버변수 -> Solution 내부에서 쓸 수 있게
//	// 타겟 넘버를 만드는 방법의 수 (dfs로 탐색했을 때 총합이 타겟 넘버와 같다면...)
//	int target; // 멤버변수화 <- 매개변수로 전달받은 타겟 넘버를 저장
//	int[] numbers; // 멤버변수화 <- 전달받은 숫자들
//
//	public int solution(int[] numbers, int target) {
//		// 1. 깊이 우선 탐색 (DFS) : 재귀함수
//		this.target = target; // 매개변수 인자 -> this.멤버변수로 이동
//		// +-를 해서 구할 숫자 (마지막 노드까지 계산해서 이 값이 나와야함)
//		this.numbers = numbers; // 숫자 목록
//		// 제공 받은 numbers의 길이만큼... depth => 반복해서 노드 탐색
//		dfs(0, 0); // 0인 깊이, 0인 합.=> dfs 탐색 (재귀) 진행
//		return answer;
//	}
//
//	// dfs가 별도의 메서드이기 때문에 solution <- 입력값. <= 이 매개변수를 직접 쓸 수 X
//	public void dfs(int depth, int sum) { // depth가 1씩 증가하면서...
//		// sum -> 현재까지 모두 더해준 값 (-> target 변수)
//		// 다음 dfs를 호출할 때 깊이와 현재까지의 합 => ...
//		// numbers[depth] -> 현재 노드의 숫자
//		// 1 : 다음에 + 노드로 이동한다 -> 탐색할 노드가 있다 -> 끝까지 도달하지 않았다
//		// 2 : 다음에 - 노드로 이동한다 -> 탐색할 노드가 있다 -> 끝까지 도달하지 않았다
//		// 3 : 끝났다 (더이상 탐색할 노드가 없다)
//		if (depth < numbers.length) { // 아직 탐색할 노드가 남아있다
//			// System.out.println("레벨 : " + depth + " 숫자 : " + numbers[depth] + " 현재까지의 합 : " + sum);
//			// 마지막 인덱스 + 1. (길이만큼) (길이 = 마지막 인덱스 + 1)
//			dfs(depth + 1, sum + numbers[depth]);
//			// 1 -> + 노드로 이동했다 => 현 depth 위치의 숫자를 더해준다
//			dfs(depth + 1, sum - numbers[depth]);
//			// 2 -> - 노드로 이동했다 => 현 depth 위치의 숫자를 빼준다
//		} else { // depth == number.length -> 더 이상 탐색할 노드가 남아있지 않음
//			// 끝까지 왔음 (조건3)
//			// 모든 연산이 끝났을 때 -> 그 총합 (sum)이 target과 일치하는가?
//			// System.out.println("레벨 : " + depth + " 현재까지의 합 : " + sum);
//			if (sum == target) {
//				answer++ ; // 1을 더해준다
//			}
//		}
//	}
//}

// 큐를 이용한 해결
//import java.util.*;
//
//class Solution {
//	public int solution(int[] numbers, int target) {
//		int answer = 0; // 방법의 가짓수
//
//		Queue<ArrayList<Integer>> q = new ArrayDeque<ArrayList<Integer>>();
//		// System.out.println(q); // Queue -> { 깊이, 합 }
//		ArrayList<Integer> list = new ArrayList<>();
//		list.add(0); // 깊이
//		list.add(0); // 합
//		q.add(list);
//		// System.out.println(q);
//		while (!q.isEmpty()) {
//			ArrayList<Integer> el = q.poll(); // 가장 오래된 요소 뽑기
//			// System.out.println(el);
//			int depth = el.get(0);
//			int sum = el.get(1);
//			// el?
//			if (depth < numbers.length) { // el -> 0: depth, 1: sum
//				// 0번째의 깊이가, numbers.length고 같게 되면.. 멈춤...
//				// el.get(0) < numbers.length -> 아직 끝까지 탐색 안했을 때
//				ArrayList<Integer> plus = new ArrayList<>();
//				// numbers[depth] -> 이번 깊이에서 확인할 숫자 (+, -)
//				plus.add(depth + 1);
//				plus.add(sum + numbers[depth]);
//				q.add(plus); // +노드로 갔을 때의 경우
//				ArrayList<Integer> minus = new ArrayList<>();
//				// numbers[depth] -> 이번 깊이에서 확인할 숫자 (+, -)
//				minus.add(depth + 1);
//				minus.add(sum - numbers[depth]);
//				q.add(minus); // -노드로 갔을 때의 경우
//			} else { // 아닐 경우 -> 끝까지 탐색했다는 것.
//				// depth가 끝까지 왔다 -> sum을 판단해서 target과 일치하면...
//				// if (sum == target) {
//				//     answer++;
//				// }
//				answer += sum == target ? 1 : 0;
//			}
//		}
//		return answer;
//	}
//}

// 스택으로 해결
//import java.util.*; // 자료구조 등 일괄 불러오기
//
//class Solution {
//	public int solution(int[] numbers, int target) {
//		// numbers -> 처리해야할 숫자들
//		// 2 - DFS => stack
//		int answer = 0; // 타겟 넘버가 나오는 식의 갯수
//
//		// 탐색한 노드를 기록해줄 stack
//		Stack<Integer> stack = new Stack<Integer>();
//
//		// 가장 앞선 숫자들을 stack에 넣기
//		stack.push(numbers[0]); // +숫자
//		stack.push(numbers[0]*-1); // -숫자
//
//		// 임시로 합을 저장해줄 리스트
//		ArrayList<Integer> list; // for문 밖에 미리 선언
//
//		for (int i = 1; i < numbers.length; i++) {
//			System.out.println(stack);
//			// 0번째 이후, 1번째 숫자들부터 -> 검색해주기 위함
//			// 탐색대상이 될 레벨의 숫자
//			int tempNumber = numbers[i];
//			System.out.println("현재 숫자 : " + tempNumber);
//			list = new ArrayList<Integer>();
//			while (!stack.isEmpty()) { // 앞서서 계산한 노드들의 합
//				int currentSum = stack.pop();
//				System.out.println("지금까지의 합 : " + currentSum);
//				list.add(currentSum + tempNumber); // +쪽으로 갔을 때
//				list.add(currentSum - tempNumber); // -쪽으로 갔을 때
//			} // 한 개의 합 -> 2개의 새로운 파생.
//			for (int sum : list) { // 직전 while에서 생성된 새로운 합들을
//				stack.push(sum); // stack 넣어서 다음 레벨에서 탐색하게 함
//			}
//			System.out.println(stack);
//		}
//		for (int s: stack) {
//			// System.out.println(s);
//			// 어쩔 때 answer에 카운트해주면 될까?
//			if (s == target) {
//				answer++;
//			}
//		}
//		return answer;
//	}
//}