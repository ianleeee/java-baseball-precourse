package baseball.domain;

// 스트라이크, 볼 개수를 보관하는 값 객체
public class Result {
    private final int strikes;
    private final int balls;

    // 스트라이크, 볼 개수를 가진 결과 생성
    public Result(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    // 스트라이크 개수 반환
    public int strikes() {
        return strikes;
    }

    // 볼 개수 반환
    public int balls() {
        return balls;
    }

    // 스트라이크와 볼이 모두 없는지 여부 반환
    public boolean isNothing() {
        return strikes == 0 && balls == 0;
    }

    // 3스트라이크인지 여부 반환
    public boolean isThreeStrikes() {
        return strikes == 3;
    }
}