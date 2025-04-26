package school.faang.microsoft;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex).forEach(index -> {
            log.info("Mail no. {} was sent by stream no. {}.",
                    index + 1,
                    Thread.currentThread().getName());
            startIndex++;
        });
    }
}
