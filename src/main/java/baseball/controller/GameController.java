package baseball.controller;

import baseball.domain.ComputerNumbers;
import baseball.domain.NumbersGenerator;

// 게임의 전체 실행 흐름을 제어
public class GameController {

    // 컴퓨터 숫자 생성을 담당하는 생성기
    private final NumbersGenerator generator;

    // 숫자 생성기 주입
    public GameController(NumbersGenerator generator) {
        this.generator = generator;
    }

    // 게임 실행
    public void run() {
        // 임의 숫자 생성
        ComputerNumbers computerNumbers = generator.generate();
        System.out.println(computerNumbers);
    }
}
