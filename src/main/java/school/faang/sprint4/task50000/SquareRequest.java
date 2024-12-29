package school.faang.sprint4.task50000;

import java.util.concurrent.ThreadLocalRandom;

public class SquareRequest {
    private static final long MIN_TIMEOUT = 1000L;
    private static final int MAX_INTEGER = 1000;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(MAX_INTEGER);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        } finally {
            resultConsumer.add(number * number);
        }
    }
}
