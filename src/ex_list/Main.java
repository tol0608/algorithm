package ex_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// 리스트 생성
//		List<String> lunchList = new List<>();
		// List는 interface. 그 자체로 생성할 수 없음
		// List를 구현할 것을 추가해줘야함
		// ArrayList, LinkedList....
		List<String> lunchList = new ArrayList<>();
		lunchList.add("케밥");
		System.out.println(lunchList); // 주소값이 뜨지않고 값이 뜸(배열은 주소값)
		// 안에 들어있는 내용들은 string으로 변환된 내용들
		System.out.println(lunchList.size());
		lunchList.add("된장찌개");
		System.out.println(lunchList.size());
		System.out.println(lunchList);
		// 가져오고 싶으면, get(index)
		System.out.println(lunchList.get(0));
		// 수정하고 싶으면, set(index, 새로운 값)
		System.out.println(lunchList.set(0, "김치찌개"));
		System.out.println(lunchList);
		// 삭제하고 싶으면, remove(index) 인덱스는 유일
		System.out.println(lunchList.remove(0));
		System.out.println(lunchList);
		// 삽입. add (맨 끝) / 수정 . set(인덱스, 값), / 조회 .get(인덱스) / 삭제 .remove(인덱스)
		String[] lunchArr = lunchList.toArray(new String[lunchList.size()]);
		System.out.println(lunchArr.getClass());
		for (String lunch : lunchArr) {
			System.out.println(lunch);
		}
		// 정렬
		lunchList.add("된장찌개");
		lunchList.add("김치찌개");
		lunchList.add("김치찜");
		lunchList.add("샌드위치");
		System.out.println(lunchList);
		Collections.sort(lunchList); // 오름차순
		System.out.println(lunchList);
		// Collections.sort(리스트, ...? 람다식 형태의 메서드 넣어서...)
		Collections.sort(lunchList, Comparator.reverseOrder()); // 내림차순
		System.out.println(lunchList);

	}
}
