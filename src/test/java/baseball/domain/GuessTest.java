package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GuessTest {

    @DisplayName("3자리 숫자 문자열을 입력하면 각 자리가 올바르게 저장된다")
    @Test
    void from_valid_input_creates_guess() {
        Guess guess = Guess.from("123");

        assertThat(guess.digitAt(0)).isEqualTo(1);
        assertThat(guess.digitAt(1)).isEqualTo(2);
        assertThat(guess.digitAt(2)).isEqualTo(3);
    }

    @DisplayName("사용자 입력은 중복 숫자를 허용한다")
    @Test
    void from_allows_duplicate_digits() {
        Guess guess = Guess.from("111");

        assertThat(guess.digitAt(0)).isEqualTo(1);
        assertThat(guess.digitAt(1)).isEqualTo(1);
        assertThat(guess.digitAt(2)).isEqualTo(1);
    }

    @DisplayName("앞뒤 공백은 제거한 뒤 검증한다")
    @Test
    void from_trims_input() {
        Guess guess = Guess.from(" 789 ");

        assertThat(guess.digitAt(0)).isEqualTo(7);
        assertThat(guess.digitAt(1)).isEqualTo(8);
        assertThat(guess.digitAt(2)).isEqualTo(9);
    }

    @DisplayName("입력값이 null이면 예외가 발생한다")
    @Test
    void from_null_throws() {
        assertThatThrownBy(() -> Guess.from(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("3자리가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", "1", "12", "1234", " 12", "12 ", "9999"})
    void from_invalid_length_throws(String input) {
        assertThatThrownBy(() -> Guess.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("숫자가 아닌 문자가 포함되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"12a", "a23", "1 3", "1,2", "+++"})
    void from_non_digit_throws(String input) {
        assertThatThrownBy(() -> Guess.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("0 또는 10 이상이 포함되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"023", "120", "900"})
    void from_out_of_range_throws(String input) {
        assertThatThrownBy(() -> Guess.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
