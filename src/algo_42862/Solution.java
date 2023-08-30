package algo_42862;

public class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		// 여벌 체육복 -> 빌려준다
		// 빌려주는 것 -> 앞뒤로만 빌려줄 수 있다 (index)
		// 앞-뒤 (독립, 전체-부분) -> 이 조건이 없으면
		// 완전탐색 문제 1번 -> 끝까지...
		// -> 가능한 많은 사람들이 체육복을 빌려야한다
		// 전체 학생의 수 n
		// 도난 당한 학생들 lost
		// 여분 reserve (여분은 1개씩 밖에 없음)
		// 도난 당했다면 여분은 의미 없음
		System.out.println(String.format("전체 학생의 수 : %d", n));
		System.out.print("도난 당한 학생들 : ");
		for (int l : lost) {
			System.out.print(l + " ");
		}
		System.out.println();
		System.out.print("여분 있는 학생들 : ");
		for (int r : reserve) {
			System.out.print(r + " ");
		}
		System.out.println();
		// 현재 자리 배치 먼저 생각해야함 (자리별로, 도난-여분을 다 정리하고 나서...)
		// int[] seat = new int[n+1]; // 1부터 n까지 인덱스를 사용 -> 0으로 다 대입되어 있는 배열
		int[] seat = new int[n + 2]; // 맨 뒷자리도 뒤를 탐색할 수 있게
		for (int l : lost) {
			// l -> 잃어버린 학생들의 자리 번호 -> index로 사용해줄 수 있음
			seat[l]--; // 1개씩 잃어버린 걸 반영함
		}
		System.out.println("체육복 현황");
		for (int s : seat) {
			System.out.print(s + " ");
		} // 0 0 -1 0 -1 0
		for (int r : reserve) {
			seat[r]++; // 1개의 여분을 반영
		}
		System.out.println();
		System.out.println("체육복 현황");
		for (int s : seat) {
			System.out.print(s + " ");
		} // 0 1 -1 1 -1 1 -> 상쇄를 배열에 반영하고 시작하고 싶은 것.
		System.out.println();
		// 체육복이 있어서 0 이상의 값을 유지한 학생들을 탐색
		int answer = 0; // 참여할 수 있는 학생
		for (int i = 1; i <= n; i++) { // 향상된 for문이 아니라 일반 인덱스로 해야할까?
			// 실제 자리가 있는 n명 탐색
			// 1부터 탐색 -> 0은 자리만 만들어둔 것이므로...
			// 내가 -1이라면 앞뒤로 검색을 해서, 0으로 만들어주는 작업
			// System.out.println(String.format("%d의 체육복 소지 여부 : %d", i, seat[i]));
			if (seat[i] == -1) { // 체육복이 없으면
				System.out.println(String.format("%d는 체육복이 없습니다", i));
				// 앞에부터 여분이 있는지 검색을 해봐요
				if (seat[i - 1] == 1) { // 앞자리 학생이 여분이 있다면
					System.out.println(String.format("%d는 앞자리에게 체육복을 빌렸습니다", i));
					seat[i - 1]--;
					seat[i]++;
					answer++; // 빌렸으니까 참석 가능
					continue;
				} // 이 이후는 앞자리에는 여분 없는 경우만 남음
				if (seat[i + 1] == 1) { // 뒷자리 학생이 여분이 있다면
					System.out.println(String.format("%d는 뒷자리에게 체육복을 빌렸습니다", i));
					seat[i + 1]--;
					seat[i]++;
					answer++; // 빌렸으니까 참석 가능
				}
			} else { // 체육복이 있으면
				answer++; // 체육복이 이미 있음
			}
		}
		System.out.println("체육복 현황");
		for (int s : seat) {
			System.out.print(s + " ");
		}
		System.out.println();
		return answer;
	}

//	public int solution(int n, int[] lost, int[] reserve) {
//		int[] seat = new int[n+2]; // 맨끝자리도 뒤를 탐색할 수 있게
//		for (int l : lost) {
//			seat[l]--;
//		}
//		for (int r : reserve) {
//			seat[r]++;
//		}
//		int answer = 0;
//		for (int i = 1; i <= n; i++) { // n명까지만 탐색 (앞뒤 한자리씩이 더 있음)
//			if (seat[i] == -1) { // 체육복이 없으면
//				if (seat[i - 1] == 1) {
//					seat[i - 1]--;
//					seat[i]++;
//					answer++;
//					continue;
//				}
//				if (seat[i + 1] == 1) {
//					seat[i + 1]--;
//					seat[i]++;
//					answer++;
//				}
//			} else {
//				answer++;
//			}
//		}
//		return answer;
//	}
}
