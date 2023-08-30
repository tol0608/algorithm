package algo_150370;

import java.util.*;

public class Solution {
	public int[] solution(String today, String[] terms, String[] privacies) {
		// [문제의 요구사항]
		// 개인정보 n개 -> 보관 유효기간
		// 개인 정보별로 '약관' -> 약관 별로 유효기간이 다 다르고...
		// 유효기간이 넘어가면 '파기'. -> 파기해야하는 것들 목록
		// [힌트]
		// 모든 달은 28일까지.

		// 탐색하는 반복문 -> 로그를 찍는 것 + 탐색을 했을 때 어떻게 사용해?
		System.out.println(today);
		// 여기서 -> 일 기준으로 변환
		StringTokenizer st = new StringTokenizer(today, ".");
		int tdYear = Integer.parseInt(st.nextToken()) * 12 * 28;
		int tdMonth = Integer.parseInt(st.nextToken()) * 28;
		int tdDay = Integer.parseInt(st.nextToken());
		int tdDateNumber = tdYear + tdMonth + tdDay;
		System.out.println(tdDateNumber);

		Map<String, Integer> tMap = new HashMap<>();
		// 약관 + 약관별 파기해야하는 개월수
		for (String t : terms) { // 변수명 고민하는 것도 시간...
			// 겹치지 않는다면 두문자를 써서(initial) 표현
			System.out.println(t);
			// Z 3 : 첫번째가 약관명(Z), 두번째가 개월수(3)
			// D 5 : 첫번째가 약관명(D), 두번째가 개월수(5)
			// 약관명 -> ...
			// **맵**
			String[] ts = t.split(" "); // space...
			String name = ts[0]; // 약관명
			int month = Integer.parseInt(ts[1]); // 개월수
			// 이 메서드는 외우세요
			tMap.put(name, month); // name이 key고 month가 value
		}
		System.out.println(tMap); // {D=5, Z=3}
		// for (String p : privacies) {
		List<Integer> list = new ArrayList(); // 조건을 만족시키는 개인정보번호
		for (int i = 0; i < privacies.length; i++) {
			String p = privacies[i];
			System.out.println(p); // 개인정보들을 조사...
			// 2019.01.01 D -> 날짜, 약관명 <- 개월수.
			// -> 날짜? => **만료되는 날짜?**
			// 현재날짜가 만료일보다 뒤라면 -> 파기
			String[] ps = p.split(" "); // space로 쪼개줌
			String pDate = ps[0]; // 개인정보 저장 날짜
			String pName = ps[1]; // 약관명
			System.out.println(pDate);
			int tMonth = tMap.get(pName); // 약관명을 통해 호출한 만료기간 (개월수)
			System.out.println(pName + " " + tMonth); // 해당 약관명과 대응되는 만료기간
			// pDate -> 연.월.일. -> 계산하기 편하려면 뭐로 통일해주는게 좋을까요?
			// 일(day)로 통일. 모든 달은 28일. 연도 -> 연도 * 12 * 28, 달 -> 달 * 28
			// pDate -> .을 기준으로 연월일이 묶여있는 문자열.
			// split해준다면? 어떠한 문자를 가지고 쪼개줘야될까요? '.'
			// String[] pDateArr = pDate.split("\\."); // \\.
			// StringTokenizer st = new StringTokenizer(pDate, ".");
			st = new StringTokenizer(pDate, ".");
			// year, month, day
			// int pYear = Integer.parseInt(pDateArr[0]) * 12 * 28;
			// int pMonth = Integer.parseInt(pDateArr[1]) * 28;
			// int pDay = Integer.parseInt(pDateArr[2]);
			int pYear = Integer.parseInt(st.nextToken()) * 12 * 28;
			int pMonth = Integer.parseInt(st.nextToken()) * 28;
			int pDay = Integer.parseInt(st.nextToken());
			int pDateNumber = pYear + pMonth + pDay;
			System.out.println(pDateNumber); // 개인정보 생성 일자를 날짜 기준으로 환산
			int expireDate = pDateNumber + tMonth * 28; // 특정 개인정보의 만료 예상기간
			System.out.println(expireDate);
			// 만료 여부를 판정하면 되는데...
			System.out.println(tdDateNumber + " " + expireDate);
			System.out.println(expireDate <= tdDateNumber); // 만료일이 현재일보다 작거나 같으면 -> 파기
			if (expireDate <= tdDateNumber) {
				// list.add(i); // 그냥 넣어도 돼요? 안됩니다. 1~n. 인덱스가 0부터가 아니라 1부터 시작해야함.
				list.add(i + 1);
			}
		}
		System.out.println(list);
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
