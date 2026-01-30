package baseball.domain;

// Guess 생성 과정에서 발생할 수 있는 에러 유형
public enum GuessError {
    NULL_INPUT("[ERROR] 입력값이 null입니다."),
    INVALID_LENGTH("[ERROR] 3자리 숫자를 입력해야 합니다."),
    NON_DIGIT("[ERROR] 숫자만 입력할 수 있습니다."),
    OUT_OF_RANGE("[ERROR] 1~9 범위의 숫자만 입력할 수 있습니다."),
    ONE_OR_TWO("[ERROR] 1 또는 2를 입력해야 합니다.");

    private final String message;

    GuessError(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
