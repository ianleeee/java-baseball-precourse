package baseball.controller;

import baseball.domain.ComputerNumbers;
import baseball.domain.Guess;
import baseball.domain.NumbersGenerator;
import baseball.view.InputView;

import java.io.IOException;

public class GameController {
    private final NumbersGenerator generator;
    private final InputView inputView;

    public GameController(NumbersGenerator generator, InputView inputView) {
        this.generator = generator; // 숫자 생성기
        this.inputView = inputView; // 유저 입력받는 객체
    }

    public void run() {
        // 컴퓨터가 생성한 숫자
        ComputerNumbers computerNumbers = generator.generate();
        System.out.println(computerNumbers);

        // 유저가 입력한 숫자
        Guess guess = readGuessUntilValid();
        System.out.println(guess);
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