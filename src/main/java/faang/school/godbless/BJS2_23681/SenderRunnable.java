package faang.school.godbless.BJS2_23681;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private static final String SUCCESS_MESSAGE = "Письмо под номером %s успешно отправлено.%n";
    private final int startIndex;
    private final int endIndex;

    @Getter
    private static int loopCounter = 0;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf(SUCCESS_MESSAGE, i);
            loopCounter++;
        }
    }
}
