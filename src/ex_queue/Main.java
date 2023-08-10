package ex_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// Queue
		// 1. ArrayList 구현
		MyQueue queue = new MyQueue();
		queue.enqueue("아이스아메리카노");
		queue.enqueue("아이스돌체라떼");
		queue.enqueue("콜드브루 따뜻하게");
//		System.out.println(queue.peek());
		System.out.println(queue.dequeue()); // 아아
		// 2. LinkedList
		LinkedList<String> queue2 = new LinkedList<>();
		// enqueue -> 새롭게 줄서기 => add
		// dequeue -> 가장 오래된사람 보내기 => poll
		// 누가 가장 오래 줄을 섰나 => peek
		queue2.add("아이스아메리카노");
		queue2.add("아이스돌체라떼");
		queue2.add("콜드브루 따뜻하게");
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		// 3. ArrayDeque
		ArrayDeque<String> queue3 = new ArrayDeque<>();
		queue3.add("아이스아메리카노"); // 1
		queue3.add("아이스돌체라떼"); // 2
		queue3.add("콜드브루 따뜻하게"); // 3
		System.out.println(queue3);
		System.out.println(queue3.poll());
		System.out.println(queue3);
		System.out.println(queue3.poll());
		System.out.println(queue3);
		System.out.println(queue3.poll());
		System.out.println(queue3);
	}
}

class MyQueue {
	private List<String> list = new ArrayList<String>(); // private 접근자

	public void enqueue(String x) {
		list.add(x);
	} // 큐 안에 x라는 요소를 저장

	public String peek() {
		return "";
	}
	// 맨 앞에 요소를 반환

	public String dequeue() {
		String x = list.get(0);
		list.remove(0); // 0번째 인덱스의 값을 삭제
		return x;
	}
	// 맨 앞에 요소를 반환하고 제거
}