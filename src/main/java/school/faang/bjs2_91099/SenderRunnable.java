package school.faang.bjs2_91099;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@AllArgsConstructor
@Getter
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    public static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            count.incrementAndGet();
            startIndex++;
        }
    }
}
