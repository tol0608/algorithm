package algo_150365;

import java.util.Stack;

public class Solution {
	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		Stack<Coordinate> stack = new Stack<>(); // DFS 탐색을 위한 스택
		stack.push(new Coordinate(x, y, "")); // 시작점을 stack에 push.

		// List<String> list = new ArrayList<>();
		while (!stack.isEmpty()) {
			Coordinate cd = stack.pop();
			// 격자로 되어 있는 두 점 사이의 거리는... (대각선 이동이 안된다면)
			// 절대값(x1 - x2) + 절대값(y1 - y2)
			int distance = Math.abs(cd.x - r) + Math.abs(cd.y - c);
			// Math.abs - absolute (절대값) : 부호를 제거한 값
			int chance = k - cd.move.length(); // 남은 이동 기회
			if (distance > chance) { // 처리해야하는 이동 거리(distance)가 남은 이동 횟수(k - move len)보다 크다면
				// cd.move.length() -> 이동하면서 move에 문자열을 붙여줬기 때문에
				// 지금까지 이동한 값
				continue;
			}

			// * 시작점과 도착점 사이의 거리와 남은 이동횟수 간의 홀짝이 맞아야함
			if (!(distance % 2 == 0 && (chance) % 2 == 0
					|| distance % 2 == 1 && (chance) % 2 == 1)) {
				continue;
			}

			if (cd.move.length() == k) { // 움직일 때마다 l,r,d,u 하나를 붙여줬으니
				if (cd.x == r && cd.y == c) {
					// list.add(cd.move);
					// 만약에 알파벳 우선탐색을 했기 때문에...
					// 누구라도 먼저 (dfs 상에서) 도착을 했다면 (k번 안에서 도착했다면)
					// 그 도착한 건 알파벳 순에서 가장 빠른 것이 됨.
					return cd.move; // String (k개의 길이를 가지는 string + 알파벳)
				} // k번 움직여보니 아닌가벼...
				continue; // 뒤에 있는 stack.push에 도달하지 않게...
			}
			if (cd.x == 0 || cd.x > n || cd.y == 0 || cd.y > m) {
				continue; // 뒤에 있는 stack.push에 도달하지 않게...
			}
			// Stack은 후입선출. (결과물이 알파벳 오름차순.)
			// 알파벳이 뒤에 있는 것이 먼저 들어가야... 알파벳 먼저 문서가 먼저 나와요
			// d, l, r, u (알파벳순) -> 이것에 역순으로 넣어주면... 알파벳 순으로 우선탐색
			stack.push(new Coordinate(cd.x - 1, cd.y, cd.move + "u"));
			stack.push(new Coordinate(cd.x, cd.y + 1, cd.move + "r"));
			stack.push(new Coordinate(cd.x, cd.y - 1, cd.move + "l"));
			stack.push(new Coordinate(cd.x + 1, cd.y, cd.move + "d"));
			// 이 탐색의 결과는 무조건 알파벳순을 보장!
		}
		// if (list.isEmpty()) {
		//     return "impossible"; // stack을 다 돌아도 경로가 안 나옴
		// }
		// Collections.sort(list); // 결국은 이게 문제
		// 정렬은 메모리를 너무 많이 잡아먹음
		// return list.get(0);
		return "impossible"; // 스택을 다 도는지 여부로 체크
	}
}

// 좌표 클래스 -> Coordinate
class Coordinate {
	int x; // x좌표
	int y; // y좌표
	String move; // 이동 경로

	Coordinate(int x, int y, String move) {
		this.x = x;
		this.y = y;
		this.move = move;
	}
}
