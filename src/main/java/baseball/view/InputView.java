package baseball.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 사용자 입력 처리(UI)
public class InputView {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 숫자 입력 안내 후 문자열 입력 수집
    public String readGuess() throws IOException {
        System.out.print("숫자를 입력해주세요 : ");
        return br.readLine();
    }

    // 재시작 여부 입력 수집 (1 또는 2)
    public String readRestart() throws IOException {
        return br.readLine();
    }
}
