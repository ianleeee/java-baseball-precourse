package baseball.domain;

// 컴퓨터 숫자와 사용자 입력을 비교해 결과를 계산
public class Judge {
    private static final int SIZE = 3;

    // 컴퓨터 숫자와 사용자 입력을 비교해 스트라이크, 볼 개수 계산
    public Result judge(ComputerNumbers answer, Guess guess) {
        int strikes = countStrikes(answer, guess);
        int balls = countBalls(answer, guess);
        return new Result(strikes, balls);
    }

    // 같은 자리에서 같은 숫자인 경우 스트라이크 개수 계산
    private int countStrikes(ComputerNumbers answer, Guess guess) {
        int count = 0;

        for (int index = 0; index < SIZE; index++) {
            if (answer.digitAt(index) == guess.digitAt(index)) {
                count++;
            }
        }

        return count;
    }

    // 자리는 다르지만 포함된 숫자인 경우 볼 개수 계산
    private int countBalls(ComputerNumbers answer, Guess guess) {
        int count = 0;

        for (int index = 0; index < SIZE; index++) {
            int value = guess.digitAt(index);

            if (answer.digitAt(index) == value) {
                continue;
            }

            if (answer.contains(value)) {
                count++;
            }
        }

        return count;
    }
}