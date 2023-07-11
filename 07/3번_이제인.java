public class MonthTest0708Q3 {
    public static int solution(int N, int[] warriors) {
        int maxConfidence = 0;
        for (int i = 0; i < N; i++) {
            int[] removedWarriors = new int[N - 1];  // 한 명의 전사를 제외한 전사 배열
            int index = 0;
            for (int j = 0; j < N; j++) {
                if (j != i) {
                    removedWarriors[index] = warriors[j];
                    index++;
                }
            }
            int confidence = calculateMaxConfidence(N - 1, removedWarriors);
            maxConfidence = Math.max(maxConfidence, confidence);
        }
        return maxConfidence;
    }

    public static int calculateMaxConfidence(int N, int[] warriors) {
        int maxConfidence = 0;
        for (int i = 0; i < N; i++) {
            int prev = warriors[(i + N - 1) % N];
            int current = warriors[i];
            int next = warriors[(i + 1) % N];

            if (current > prev && current > next) {
                maxConfidence++;
            }
        }
        return maxConfidence;
    }

    public static void main(String[] args) {
        int n1 = 8;
        int[] warriors1 = {7, 7, 5, 8, 9, 4, 6, 2};
        int result1 = solution(n1, warriors1);
        System.out.println(result1);

        int n2 = 10;
        int[] warriors2 = {5, 3, 7, 5, 3, 3, 6, 1, 8, 7};
        int result2 = solution(n2, warriors2);
        System.out.println(result2);

        int n3 = 12;
        int[] warriors3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int result3 = solution(n3, warriors3);
        System.out.println(result3);
    }
}
/*

maxConfidence 변수는 최대 자신감점수를 저장하는 변수.
for 루프를 통해 한 명의 전사를 제외하고 계산을 진행합니다.
i 변수는 제외할 전사의 인덱스

removedWarriors 배열은 한 명의 전사를 제외한 전사들을 저장하기 위한 배열
이중 for 루프를 통해 전사들을 순회하며,
removedWarriors 배열에 제외할 전사를 제외한 나머지 전사들을 복사
calculateMaxConfidence 함수를 호출하여 removedWarriors
배열로 가능한 최대 자신감점수를 계산
이 값을 confidence 변수에 저장

Math.max 함수를 사용하여 maxConfidence 변수와
confidence 변수 중 큰 값을 선택하여 maxConfidence 변수에 할당

모든 전사에 대해 반복한 후, 최대 자신감점수인 maxConfidence를 반환
N은 전체 전사 수를
warriors 배열은 전사들의 전투력을 저장

for 루프를 통해 전사들을 순회하며,
이전 전사의 전투력 prev,
현재 전사의 전투력 current,
다음 전사의 전투력 next를 계산

if 문을 사용하여 현재 전사의 전투력이
이전 전사와 다음 전사의 전투력보다 크면 자신감점수를 증가

최대 자신감점수인 maxConfidence 값을 반환
 */


/*
<테스트케이스 1>
N:8
warriors : [7,7,5,8,9,4,6,2]
정답 : 3
<테스트케이스 2>
N:10
warriors : [5,3,7,5,3,3,6,1,8,7]
정답 : 3

<테스트케이스 3>
N:12
warriors : [1,2,3,4,5,6,7,8,9,10,11,12]
정답 : 1
 */
