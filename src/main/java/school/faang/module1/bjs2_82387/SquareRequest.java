package school.faang.module1.bjs2_82387;

import java.util.concurrent.ThreadLocalRandom;

public class SquareRequest {

    private static final long MIN_TIMEOUT = 3000L;
    private static final int MAX_RANDOM_TIMEOUT = 1000;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(MAX_RANDOM_TIMEOUT);
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