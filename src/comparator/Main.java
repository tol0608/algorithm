package comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		// 생성자
		// 배열 -> 별도로 import X
		// 타입[] 변수명 = new 타입[길이];
		String[] lunchMenu = new String[5];
		// 배열 arr, array, ...?
		// 배열(변수명)명.length -> 해당 배열의 길이
		System.out.println(lunchMenu.length);
		lunchMenu[0] = "돈까스";
		lunchMenu[1] = "제육볶음";
		lunchMenu[2] = "샌드위치";
		lunchMenu[3] = "샐러드";
		lunchMenu[4] = "햄버거";

		for (int i = 0; i < lunchMenu.length; i++) {
			System.out.println(lunchMenu[i]);
		}
		// 꼭 인덱스를 쓰지 않아도 될때
		// 향상된 for문
		Arrays.sort(lunchMenu);
		// string의 경우 가나다라 순으로 정렬
		System.out.println("Arrays.sort(lunchMenu)");
		for (String menu : lunchMenu) {
			System.out.println(menu);
		}
		Arrays.sort(lunchMenu, Comparator.reverseOrder());
		// Comparator 비교해주는 기능
		// Comparator.reverseOrder() 결과를 반대의 순서대로 정렬
		System.out.println("Arrays.sort(lunchMenu, Comparator.reverseOrder())");
		for (String menu : lunchMenu) {
			System.out.println(menu);
		}
	}
}
