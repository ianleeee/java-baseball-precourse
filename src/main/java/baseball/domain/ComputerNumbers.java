package baseball.domain;

// 컴퓨터가 뽑은 임의의 수를 하나의 객체로 관리
public class ComputerNumbers {
    private final int[] digits;

    public ComputerNumbers(int[] digits) {
        this.digits = digits;
    }


    // 특정 위치의 숫자 조회
    public int digitAt(int index) {
        return digits[index];
    }

    // 디버깅 용
    @Override
    public String toString() {
        return "digits: " + digits[0] + digits[1] + digits[2];
    }
}
