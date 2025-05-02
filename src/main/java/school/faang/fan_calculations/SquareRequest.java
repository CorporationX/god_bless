package school.faang.fan_calculations;

import java.util.concurrent.ThreadLocalRandom;

public class SquareRequest {
    private static final long MIN_TIMEOUT = 300L;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(10);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            resultConsumer.add(number * number);
        }
    }
}