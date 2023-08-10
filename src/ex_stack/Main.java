package ex_stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		System.out.println("Stack");
		Stack<String> stack = new Stack<>();
		// 끝 값 확인하는 것, 새로 추가하는 것(push), 가장 최신에 추가한 걸 밖으로 꺼내는 것.
		stack.push("리액트를 다루는 기술");
		stack.push("자료구조와 함께 배우는 알고리즘 입문");
		stack.push("HTML+CSS+자바스크립트 웹 표준의 정석");
		System.out.println(stack); // 먼저 push된 순으로 안으로 들어가 있음
		// 꺼내기 전에 확인하는 거 (peek)
		System.out.println(stack.peek()); // HTML+CSS+자바스크립트 웹 표준의 정석
		System.out.println(stack.pop()); // -> 가장 최신에 넣은 값 (반환 후 삭제)
		System.out.println(stack);
		System.out.println(stack.pop()); // -> 가장 최신에 넣은 값 (반환 후 삭제)
		System.out.println(stack);
		System.out.println(stack.pop()); // -> 가장 최신에 넣은 값 (반환 후 삭제)
		System.out.println(stack);

		System.out.println("ArrayDeque");
		ArrayDeque<String> stack2 = new ArrayDeque<>();
		// 끝 값 확인하는 것, 새로 추가하는 것(push), 가장 최신에 추가한 걸 밖으로 꺼내는 것.
		stack2.push("리액트를 다루는 기술");
		stack2.push("자료구조와 함께 배우는 알고리즘 입문");
		stack2.push("HTML+CSS+자바스크립트 웹 표준의 정석");
		System.out.println(stack2); // 먼저 push된 순으로 안으로 들어가 있음
		// 꺼내기 전에 확인하는 거 (peek)
		System.out.println(stack2.peek()); // HTML+CSS+자바스크립트 웹 표준의 정석
		System.out.println(stack2.pop()); // -> 가장 최신에 넣은 값 (반환 후 삭제)
		System.out.println(stack2);
		System.out.println(stack2.pop()); // -> 가장 최신에 넣은 값 (반환 후 삭제)
		System.out.println(stack2);
		System.out.println(stack2.pop()); // -> 가장 최신에 넣은 값 (반환 후 삭제)
		System.out.println(stack2);
	}

}
