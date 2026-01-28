package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersGeneratorTest {

    @DisplayName("컴퓨터 숫자는 3자리로 생성")
    @Test
    void generate_creates_three_digits() {
        NumbersGenerator generator = new NumbersGenerator();

        ComputerNumbers numbers = generator.generate();

        assertThat(numbers).isNotNull();
        // digitAt이 0~2까지 접근 가능하면 3자리 보장
        assertThat(numbers.digitAt(0)).isNotNull();
        assertThat(numbers.digitAt(1)).isNotNull();
        assertThat(numbers.digitAt(2)).isNotNull();
    }

    @DisplayName("컴퓨터 숫자의 각 자리는 1~9 범위")
    @Test
    void generate_digits_are_between_1_and_9() {
        NumbersGenerator generator = new NumbersGenerator();

        ComputerNumbers numbers = generator.generate();

        assertThat(numbers.digitAt(0)).isBetween(1, 9);
        assertThat(numbers.digitAt(1)).isBetween(1, 9);
        assertThat(numbers.digitAt(2)).isBetween(1, 9);
    }

    @DisplayName("컴퓨터 숫자는 서로 다른 3개의 숫자")
    @Test
    void generate_digits_are_distinct() {
        NumbersGenerator generator = new NumbersGenerator();

        ComputerNumbers numbers = generator.generate();

        Set<Integer> set = new HashSet<>();
        set.add(numbers.digitAt(0));
        set.add(numbers.digitAt(1));
        set.add(numbers.digitAt(2));

        assertThat(set).hasSize(3);
    }
}
