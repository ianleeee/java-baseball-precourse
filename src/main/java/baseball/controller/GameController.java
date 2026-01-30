package baseball.controller;

import baseball.domain.*;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.io.IOException;

import static baseball.domain.GuessError.ONE_OR_TWO;

public class GameController {
    private final NumbersGenerator generator;
    private final InputView inputView;
    private final OutputView outputView;
    private final Judge judge;

    public GameController(NumbersGenerator generator, InputView inputView, OutputView outputView, Judge judge) {
        this.generator = generator;   // 컴퓨터 숫자 생성기
        this.inputView = inputView;   // 사용자 입력 담당 뷰
        this.outputView = outputView; // 결과 출력 담당 뷰
        this.judge = judge;     // 스트라이크, 볼 판단
    }

    // 게임 실행
    public void run() {
        while (true) {
            // 한 판 게임 시작
            playOneGame();

            // 1이면 재시작, 2이면 종료
            boolean restart = askToRestart();
            if (restart) continue;
            return;
        }
    }

    // 한 판 게임 실행(컴퓨터 숫자 생성 → 입력/판정 반복 → 3스트라이크 시 종료)
    private void playOneGame() {
        // 컴퓨터가 생성한 숫자
        ComputerNumbers answer = generator.generate();

        // 올바른 사용자 input이 들어오면 스트라이크/볼 판정 후 3스트라이크가 되면 게임 종료
        while (true) {
            Guess guess = readGuessUntilValid();
            Result result = judge.judge(answer, guess);
            outputView.printResult(result);

            if (result.isThreeStrikes()) {
                outputView.printWinMessage();
                return;
            }
        }
    }

    // 재시작 여부를 묻고 1이면 true, 2면 false를 반환 (유효한 입력이 들어올 때까지 재시도)
    private boolean askToRestart() {
        while (true) {
            try {
                outputView.printRestartMessage();
                String input = inputView.readRestart();
                if ("1".equals(input)) return true;
                if ("2".equals(input)) {
                    outputView.printGameTerminateMessage();
                    return false;
                }
                outputView.printError(ONE_OR_TWO.message());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 올바르게 입력할때 까지 재시도 - Guess는 사용자가 입력할 예측값
    private Guess readGuessUntilValid() {
        while (true) {
            try {
                return Guess.from(inputView.readGuess());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}