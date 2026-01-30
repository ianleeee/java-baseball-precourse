package baseball.domain;

import java.util.Objects;

// 사용자가 입력한 3자리 숫자를 도메인 객체로 표현
public class Guess {
    private static final int SIZE = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    private final int[] digits;

    // 숫자 3자리를 내부 상태로 보관
    private Guess(int[] digits) {
        this.digits = digits;
    }

    // 사용자 입력을 순서대로 검증한 뒤 Guess로 변환
    public static Guess from(String input) {
        String value = validateNotNullAndTrim(input);
        validateLength(value);
        validateDigits(value);
        int[] digits = toDigits(value);
        validateRange(digits);
        return new Guess(digits);
    }

    // 지정한 위치의 숫자 반환
    public int digitAt(int index) {
        return digits[index];
    }

    // null 여부 확인 후 앞뒤 공백 제거
    private static String validateNotNullAndTrim(String input) {
        Objects.requireNonNull(input, GuessError.NULL_INPUT.message());
        return input.trim();
    }

    // 입력 문자열의 길이가 정확히 3인지 검증
    private static void validateLength(String value) {
        if (value.length() != SIZE) {
            throw new IllegalArgumentException(GuessError.INVALID_LENGTH.message());
        }
    }

    // 모든 문자가 숫자인지 검증
    private static void validateDigits(String value) {
        for (int i = 0; i < SIZE; i++) {
            if (!Character.isDigit(value.charAt(i))) {
                throw new IllegalArgumentException(GuessError.NON_DIGIT.message());
            }
        }
    }

    // 각 자리 숫자가 1~9 범위인지 검증
    private static void validateRange(int[] digits) {
        for (int digit : digits) {
            if (digit < MIN || digit > MAX) {
                throw new IllegalArgumentException(GuessError.OUT_OF_RANGE.message());
            }
        }
    }

    // 문자열의 각 문자를 정수 배열로 변환
    private static int[] toDigits(String value) {
        int[] result = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            result[i] = value.charAt(i) - '0';
        }
        return result;
    }

    // 디버깅 용
    @Override
    public String toString() {
        return "유저가 입력한 숫자: " + digits[0] + digits[1] + digits[2];
    }
}