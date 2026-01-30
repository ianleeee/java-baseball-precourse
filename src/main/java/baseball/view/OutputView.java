package baseball.view;

import baseball.domain.Result;

// 판정 결과를 콘솔에 출력하는 뷰
public class OutputView {

    // 스트라이크, 볼 개수에 따라 결과 문자열을 출력
    public void printResult(Result result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        String message = buildMessage(result);
        System.out.println(message);
    }

    // 스트라이크, 볼 개수에 맞는 메시지 생성
    private String buildMessage(Result result) {
        StringBuilder builder = new StringBuilder();

        int strikes = result.strikes();
        if (strikes > 0) {
            builder.append(strikes)
                    .append("스트라이크 ");
        }

        int balls = result.balls();
        if (balls > 0) {
            builder.append(balls)
                    .append("볼");
        }

        return builder.toString().trim();
    }

    // 사용자가 3스트라이크를 맞혔을 때 출력
    public void printWinMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    // 게임 재시작 안내 출력
    public void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    // 게임 종료 메시지 출력
    public void printGameTerminateMessage() {
        System.out.println("게임을 종료하겠습니다.");
    }

    // [ERROR] 메시지 출력용 편의 메서드
    public void printError(String message) {
        System.out.println(message);
    }
}