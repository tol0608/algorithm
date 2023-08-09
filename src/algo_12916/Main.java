package algo_12916;

class Solution {
	boolean solution(String s) {
		int pCount = 0;
		int yCount = 0;

		for (char c : s.toCharArray()) {
			if (c == 'p' || c == 'P') {
				pCount++;
			} else if (c == 'y' || c == 'Y') {
				yCount++;
			}
		}

		return pCount == yCount;
	}
}

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();

		String input1 = "pPoooyY";
		String input2 = "Pyy";

		boolean result1 = solution.solution(input1);
		boolean result2 = solution.solution(input2);

		System.out.println("Result 1: " + result1); // Result 1: true
		System.out.println("Result 2: " + result2); // Result 2: false
	}
}
