package faang.school.godbless.BJS2_23681;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    @Getter
    private static final AtomicInteger loopCounter = new AtomicInteger(0);
    private static final String SUCCESS_MESSAGE = "Письмо под номером %s успешно отправлено.%n";
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf(SUCCESS_MESSAGE, i);
            loopCounter.incrementAndGet();
        }
    }
}