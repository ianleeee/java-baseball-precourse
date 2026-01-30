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
}