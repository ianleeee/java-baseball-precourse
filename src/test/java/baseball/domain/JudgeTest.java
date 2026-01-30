package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    @DisplayName("숫자와 자리가 모두 같으면 스트라이크로 판정")
    @Test
    void judge_all_strikes() {
        ComputerNumbers answer = new ComputerNumbers(new int[]{1, 2, 3});
        Guess guess = Guess.from("123");

        Result result = new Judge().judge(answer, guess);

        assertThat(result.strikes()).isEqualTo(3);
        assertThat(result.balls()).isZero();
        assertThat(result.isThreeStrikes()).isTrue();
    }

    @DisplayName("자리는 다르지만 같은 숫자면 볼로 판정")
    @Test
    void judge_only_balls() {
        ComputerNumbers answer = new ComputerNumbers(new int[]{1, 2, 3});
        Guess guess = Guess.from("312");

        Result result = new Judge().judge(answer, guess);

        assertThat(result.strikes()).isZero();
        assertThat(result.balls()).isEqualTo(3);
        assertThat(result.isNothing()).isFalse();
    }

    @DisplayName("스트라이크와 볼이 함께 존재할 수 있다")
    @Test
    void judge_strikes_and_balls() {
        ComputerNumbers answer = new ComputerNumbers(new int[]{1, 2, 3});
        Guess guess = Guess.from("132");

        Result result = new Judge().judge(answer, guess);

        assertThat(result.strikes()).isEqualTo(1);
        assertThat(result.balls()).isEqualTo(2);
    }

    @DisplayName("겹치는 숫자가 하나도 없으면 낫싱")
    @Test
    void judge_nothing() {
        ComputerNumbers answer = new ComputerNumbers(new int[]{1, 2, 3});
        Guess guess = Guess.from("456");

        Result result = new Judge().judge(answer, guess);

        assertThat(result.strikes()).isZero();
        assertThat(result.balls()).isZero();
        assertThat(result.isNothing()).isTrue();
    }
}
