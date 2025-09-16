package school.faang.bjs2_91099;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@AllArgsConstructor
@Getter
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    public static AtomicLong count = new AtomicLong(0);

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            count.incrementAndGet();
            startIndex++;
        }
    }
}
