package ex_map;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {

		// 모든 자료구조형 -> 생성
//		Map<String, Integer> map = new Map<>(); // 자동 import : ctrl + shift + 'o'
		// Map<K, V>
		// K : key로 사용할 타입
		// V : value로 사용할 타입
		// 타입들은 원시 자료형을 직접넣을 수 없고, Wrapper Class
		// 오류 -> 왜? -> Map은 Interface. 구현된 Class가 아님!
		Map<String, Integer> map = new HashMap<>(); // 해싱을 사용해서 구현한 Map (HashMap)
		// 선언, 할당, 초기화 다 쪼개도 상관 없음!
		System.out.println(map); // {} - 배열 리터럴 모양과 유사

		// 자료구조형 -> CRUD
		// Create : (자료 구조 안에) 데이터를 추가
		// Read : 데이터를 읽어들임
		// Update : 데이터를 수정
		// Delete : 데이터를 삭제

		// 추가, 생성 (put)
		map.put("국어", 990); // map -> 성적표
		map.put("수학", -256);
//		map.put("영어", 3.141592); // double은 못 넣는다
		map.put("영어", 31);
//		map.put(816, 31); // key가 string이어야 한다
		System.out.println(map); // {국어=990, 수학=-256, 영어=31}

		// 읽기, 불러오기 (get)
//		map : 국어, 수학, 영어
		System.out.println(map.get("영어")); // 31
		// 한 줄 지우기 (Ctrl+D)
		System.out.println(map.get("국어")); // 990
		System.out.println(map.get("수학")); // -256
		// 없는키? -> null
		System.out.println(map.get("과학")); // null
		// ??? => 자료구조 => 구체적인 값을 가지는게 편하겠죠?
		// 기본값
		// getOrDefault
		System.out.println(map.getOrDefault("사회", -1)); // null일 경우에는 기본값을 반환한다
		System.out.println(map.getOrDefault("영어", -1)); // 존재하는 키는 그 값을 가져온다
		// 없으면 '미제출자입니다' -> null 이냐를 검사하는 방법
		// 포함하다 - contain (컨테이너) -> key(특정한 키) => containsKey
		System.out.println(map.containsKey("사회")); // false
		System.out.println(map.containsKey("영어")); // true / 키가 존재하는지 여부를 확인
		// containsValue
		System.out.println(map.containsValue(990)); // true
		System.out.println(map.containsValue(0)); // false
		// containsKey하고 containsValue의 차이점?

		// 수정? put을 그대로 씀.
		System.out.println(map);
		map.put("영어", 100); // 한 개의 키에는 하나의 대응하는 값만 존재 가능해서
		// 키에 새로운 값을 넣는다 = 수정이다
		System.out.println(map);

		// 삭제
		System.out.println(map);
		map.remove("수학"); // 수학-이라는 키를 가진 데이터를 삭제하고 싶다
		System.out.println(map);
		System.out.println(map.get("수학")); // null

		// 전체 키의 목록을 받아오고 싶다
		System.out.println(map.keySet()); // Set -> 중복이 없는 데이터 묶음
		// 전체 값들의 목록을 받아오고 싶다
		System.out.println(map.values());
		map.put("수학", 990);
		System.out.println(map.values()); // values는 고유한(딱 1개만 존재한) 값이 아님.

		// 키-값의 쌍을 보고 싶다
		System.out.println(map.entrySet()); // 스포츠 경기할 때 출전한 목록 -> 엔트리?
		// Entry -> 이름만 나옵니까? - 등번호, 출신클럽, 성적... -> 여러가지의 값들의 묶음쌍 엔트리.
		// 이 엔트리는? - key, value.
	}

}
