package algo_64061;

import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();

		// Example input values for the board and moves
		int[][] board = {
				{0, 0, 0, 0, 0},
				{0, 0, 1, 0, 3},
				{0, 2, 5, 0, 1},
				{4, 2, 4, 4, 2},
				{3, 5, 1, 3, 1}
		};

		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

		int result = solution.Solution(board, moves);
		System.out.println("The number of removed dolls: " + result);
	}
}

class Solution {
	public int Solution(int[][] board, int[] moves) {
		ArrayDeque<Integer> stack = new ArrayDeque<>(); // moves를 통해서 열을 지정해서 (1~5)
		int answer = 0; // 같은 것이 '펑'한 횟수
		for (int move : moves) {
			for (int row = 0; row < board.length; row++) {
				if (board[row][move - 1] != 0) {
					int doll = board[row][move - 1];
					if (!stack.isEmpty() && doll == stack.peek()) {
						stack.pop(); // 직전 거를 삭제만..
						answer += 2; // 짝을 맞춰서 2개 사라짐
					} else {
						stack.push(board[row][move - 1]);
					}
					board[row][move - 1] = 0; // 그 자리를 0으로 만들어준다
					break; // 그러고 반복 멈춤
				}
			}
		}
		return answer;
	}
}


// 제출용

//import java.util.*;
//
//class Solution {
//	public int solution(int[][] board, int[] moves) {
//		ArrayDeque<Integer> stack = new ArrayDeque<>(); // moves를 통해서 열을 지정해서 (1~5)
//		int answer = 0; // 같은 것이 '펑'한 횟수
//		for (int move : moves) {
//			for (int row = 0; row < board.length; row++) {
//				if (board[row][move - 1] != 0) {
//					int doll = board[row][move - 1];
//					if (!stack.isEmpty() && doll == stack.peek()) {
//						stack.pop(); // 직전 거를 삭제만..
//						answer+=2; // 짝을 맞춰서 2개 사라짐
//					} else {
//						stack.push(board[row][move - 1]);
//					}
//					board[row][move - 1] = 0; // 그 자리를 0으로 만들어준다
//					break; // 그러고 반복 멈춤
//				}
//			}
//		}
//		return answer;
//	}
//}
