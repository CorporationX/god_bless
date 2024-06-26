package faang.school.godbless.asynch3;

import java.util.concurrent.ThreadLocalRandom;

public record SquareRequest(Long number) {
    private static final long MIN_TIMEOUT = 3000L;
    private static final int MAX_VALUE = 1000;

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(MAX_VALUE);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            resultConsumer.add(number * number);
        }
    }
}
