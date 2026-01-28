package baseball;

import baseball.controller.GameController;
import baseball.domain.NumbersGenerator;

// 프로그램 실행 시작점
public class Application {
    public static void main(String[] args) {
        // 컴퓨터 숫자 생성을 담당하는 생성기 준비
        NumbersGenerator generator = new NumbersGenerator();

        // 게임 실행 흐름을 제어하는 컨트롤러 생성
        GameController gameController = new GameController(generator);

        // 숫자 야구 게임 실행
        gameController.run();
    }
}

