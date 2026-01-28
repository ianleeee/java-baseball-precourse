package baseball.domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 컴퓨터가 사용할 숫자 3개를 생성하는 역할을 담당
 * 책임:
 * - 1~9 범위의 숫자를 사용
 * - 서로 다른 숫자 3개를 생성
 * - 생성된 결과를 ComputerNumbers 객체로 반환
 * 숫자의 유효성(범위, 중복 없음)은 생성 과정에서 보장 (단위 테스트 진행)
 */
public class NumbersGenerator {
    // 생성할 숫자의 개수
    private static final int SIZE = 3;

    // 생성 가능한 숫자의 최댓값 (1 ~ 9)
    private static final int MAX = 9;

    // 난수 생성을 위한 Random 객체
    private final Random random = new Random();

    // 1~9 범위의 서로 다른 숫자 3개를 생성하여 ComputerNumbers로 반환
    public ComputerNumbers generate() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < SIZE) {
            numbers.add(randomNumber());
        }

        return new ComputerNumbers(toArray(numbers));
    }

    // 1~9 범위의 난수 하나를 생성
    private int randomNumber() {
        return random.nextInt(MAX) + 1; // 1 ~ 9
    }

    // 생성된 숫자 Set를 배열 형태로 변환
    private int[] toArray(Set<Integer> numbers) {
        int[] result = new int[SIZE];
        int index = 0;

        for (int number : numbers) {
            result[index] = number;
            index++;
        }

        return result;
    }
}
