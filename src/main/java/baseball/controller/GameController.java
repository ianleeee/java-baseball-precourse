package baseball.controller;

import baseball.domain.*;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.io.IOException;

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

    public void run() {
        // 컴퓨터가 생성한 숫자
        ComputerNumbers computerNumbers = generator.generate();
        System.out.println(computerNumbers);

        while (true) {
            // 유저가 입력한 숫자
            Guess guess = readGuessUntilValid();
            System.out.println(guess);
            Result result = judge.judge(computerNumbers, guess);
            outputView.printResult(result);

            if (result.isThreeStrikes()) return; // 3스트라이크면 종료
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