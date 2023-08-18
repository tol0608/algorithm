package algo_42576;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public String solution(String[] participant, String[] completion) {
		// participant -> 참여한 선수가 담긴 배열
		// completion -> 완주한 선수가 담긴 배열
		// answer -> 완주하지 못한 선수의 이름
		// 참가자 중에는 동명이인이 있을 수 있습니다
		// John이 두 명이고, 한 명이 완주하지 못했다
		// p -> John, John / c -> John ...
		// 특정한 이름에 -> 동명이인이 있을 수 있고,
		// 한 이름에 중복 참가자들이 있을 경우, 완주자랑 비교.
		// 갯수를 세는 문제. -> Map. (HashMap)
		// 참가자가 더 많다.
		Map<String, Integer> pMap = new HashMap<>();
		for (String p : participant) {
			// get을 통해서 특정한 키와 대응하는 value를 가져올 수 있는데
			// 만약에 그 키가 없다면 null을 가져오므르
			// getOrDefault -> null 대신에 어떠한 기본값을 써준다? 0.
			int prevCount = pMap.getOrDefault(p, 0);
			// 이전까지 특정한 이름에 대한 갯수 센 데이터 -> 없다면 기본값 0
			pMap.put(p, prevCount + 1);
		}
		System.out.println(pMap);
		// pMap을 통해서 '모든 참가자의 중복 없는 이름' -> key
		// pMap.keySet()
		for (String key : pMap.keySet()) {
			System.out.println(key); // 키 목록 전체탐색(순회)
		}
		// completion -> 완주자
		for (String c : completion) {
			System.out.println(c); // 완주자 배열을 탐색
			// pMap에서 완주자가 있다면 그 완주자를 제거
			// -> 1명의 완주하지 못한 선수
			// -> 동명이인일 수 있는데, 어쨌든 1명이니까
			// 제거하다하다 1명이 남으면... 그 사람이 완주하지 못한...
			if (pMap.get(c) == 1) { // 완주한 선수명 -> 참가선수맵
				// 해당 선수 참가자가 1명 -> 지금 참가자가 only
				pMap.remove(c); // 참가자 명단에서 더 이상 그 이름이 없음
			} else {
				// 2명 이상일 경우
				pMap.put(c, pMap.get(c) - 1); // 1명 제거
				// 동명이인의 경우 -> 완주자 1명을 빼고 다시 배열을 탐색
			}
		}
		System.out.println(pMap); // 유일한 키가 -> 완주하지 못한 사람
		for (String key : pMap.keySet()) {
			return key; // 1개 밖에 없으니까...
		}
		return "";
	}
}

// 효율성 통과용

//	class Solution {
//		public String solution(String[] participant, String[] completion) {
//			Map<String, Integer> pMap = new HashMap<>();
//			for (String p : participant) {
//				int prevCount = pMap.getOrDefault(p, 0);
//				pMap.put(p, prevCount + 1);
//			}
//			for (String c : completion) {
//				if (pMap.get(c) == 1) { // 완주한 선수명 -> 참가선수맵
//					pMap.remove(c); // 참가자 명단에서 더 이상 그 이름이 없음
//				} else {
//					pMap.put(c, pMap.get(c) - 1); // 1명 제거
//				}
//			}
//			for (String key : pMap.keySet()) {
//				return key; // 1개 밖에 없으니까...
//			}
//			return "";
//		}
//	}
