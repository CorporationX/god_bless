package school.faang.bjs249922;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
public class SquareRequest {
    private static final long MIN_TIMEOUT = 1000L;
    private static final int BOUND = 1000;
    private final Long number;

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(BOUND);

        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            log.error("The tread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        } finally {
            resultConsumer.add(number * number);
        }
    }
}