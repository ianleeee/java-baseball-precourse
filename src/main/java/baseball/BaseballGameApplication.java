package baseball;

import baseball.controller.GameController;
import baseball.domain.Judge;
import baseball.domain.NumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

// 숫자 야구 게임 시작점
public class BaseballGameApplication {

    public static void main(String[] args) {
        // 게임 실행 흐름을 제어하는 컨트롤러 구성
        GameController gameController = new GameController(new NumbersGenerator(), new InputView(), new OutputView(), new Judge());

        // 숫자 야구 게임 실행
        gameController.run();
    }
}