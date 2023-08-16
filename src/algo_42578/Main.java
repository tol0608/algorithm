package algo_42578;

import java.util.HashMap;
import java.util.Map;
import java.util.*;


public class Main {
	public int solution(String[][] clothes) {
		// 각 종류별로 최대 1가지 의상
		// -> 키 별로 1가지 값만 존재할 수 있다
		int answer = 0;
		return answer;
	}
}

// 제출용
//class Solution {
//	public int solution(String[][] clothes) {
//		// 각 종류별로 최대 1가지 의상
//		// -> 키 별로 1가지 값만 존재할 수 있다
//		// '서로 다른 옷의 조합' -> 스타일
//		for (String[] c : clothes) {
//			for (String s : c) {
//				System.out.print(s + " ");
//			}
//			System.out.println();
//		}
//		Map<String, Integer> map = new HashMap<>();
//		for (String[] c : clothes) {
//			// i = 0 : 각기 옷의 이름
//			// i = 1 : 옷의 종류 (겹치면 안됨)
//			// map.put(c[1], 1);
//			// 같은 카테고리는 key를 통해서 한 번만 저장...
//			// 이미 카테고리가 저장이 되어 있다면, +1을 해주고,
//			// 없다면 1을 대입해주는 조건
//			// if (map.containsKey(c[1])) {
//			//     // 있다는 것은, 이미 1이 put 되어 있다는 의미이므로
//			//     map.put(c[1], map.get(c[1]) + 1);
//			//     // +1한 값으로 재대입(재할당, 수정)
//			//     // map을 통해서 특정한 값을 세는 방법
//			// } else {
//			//     map.put(c[1], 1); // 없으면 null 나오니까
//			//     // 안정적으로 put
//			// }
//			map.put(c[1], map.getOrDefault(c[1], 0) + 1);
//
//		}
//		System.out.println(map); // 각각의 옷의 종류를 key.
//		// 각 종류가 뭔지는 중요하지 않음 (겹치는 건 어차피 같은 key 합쳐짐)
//		// values들만 중요함
//		System.out.println(map.values());
//		// 가짓수 -> 각각의 항목들의 갯수들을 모두 곱해주면...
//		// 햄버거 - 음료 (햄버거나 음료 중에 한쪽 안시켜도 되는 확률의 조합)
//		// (불고기, 새우, 치킨) / (콜라, 사이다)
//		// (3 + 1) * (2 + 1)
//		// 코니는 하루에 최소 한 개의 의상은 입습니다. -> 전부 선택 안함
//		// 전부 선택하지 않음 -> 1
//		// 1. 특정한 카테고리를 아예 선택하지 않음 (개별 가짓수 + 1)
//		// 2. 그래도 뭐라도 하나는 선택해야함 (전체 가짓수 - 1)
//		int answer = 1;
//		for (int v : map.values()) {
//			// 1 : 특정한 카테고리의 수 = map.values()의 원소들
//			answer *= (v + 1); // 안 입는다 옵션까지 합해서 +1로 곱해줌
//		}
//		answer -= 1; // '아무것도 안입는다'는 없으니까
//		return answer;
//	}
//}