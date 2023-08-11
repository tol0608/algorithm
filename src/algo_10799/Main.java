package algo_10799;

// https://www.acmicpc.net/problem/10799
import java.util.Scanner;
import java.util.Stack;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == '(') {
				stack.push(c);
				continue;
			}
			if (c == ')') {
				stack.pop();
				if (line.charAt(i - 1) == '(') {
					answer += stack.size();
				} else {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}

// 풀이용
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String line = sc.nextLine(); // 입력
//		sc.close();
//		// 여러 개의 열고 닫는 괄호가 있어도, 여는 괄호엔 괄호가 닫는 괄호는 하나씩.
//		// 앞으로부터 접근을 하면, 여는 괄호 1개랑 여는 괄호를 매칭.
//		// Stack을 사용!
//		Stack<Character> stack = new Stack<>(); // ArrayDeque으로 해도 됨
//		int answer = 0;
////		for (char c : line.toCharArray()) { // String -> char[]
//		for (int i = 0; i < line.length(); i++) {
//			char c = line.charAt(i);
//			// 레이더 () 이외에 '(' 열린 괄호의 경우에는 계속 쇠막대기가 존재
//			// ')' 닫린 괄호를 만나야 더 이상 존재하지 않는 것
//			// 즉, '(' 괄호를 stack에 쌓아놓으면 그만큼 쇠막대가 생긴다
//			if (c == '(') { // 열린 괄호면 스택에 넣는다
//				stack.push(c); // 맨 시작은 열린 괄호이기 때문에...
//				continue;
//			}
//			if (c == ')') { // 이미 스택에 열린 괄호 1개 이상이 존재
//				stack.pop(); // 닫힌 괄호라면...
//				if (line.charAt(i - 1) == '(') {
//					// 그 전 괄호가 열린 괄호라면
//					answer += stack.size(); // 그 전에 쌓인 열린 괄호(쇠막대)
//				} else { // 그 전 괄호가 닫힌 괄호라면 레이저가 아님.
//					answer++;
//				}
//			}
//			System.out.println(answer);
//			System.out.println(stack);
//		}
//		System.out.println(answer); // 이걸 출력
//	}
//
//}
