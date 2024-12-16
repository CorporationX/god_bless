package school.faang.task48060;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@AllArgsConstructor
@Slf4j
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex).forEach(i -> {
            Thread thread = Thread.currentThread();
            log.info("{} письмо {} отправлено%n", thread.getId(), i);
        });
    }
}
