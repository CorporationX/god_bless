package derschrank.sprint04.task09.bjstwo_49915;

import java.util.concurrent.ThreadLocalRandom;

public class SquareRequest {
    private static final int MIN_TIMEOUT = 100;
    private static final int MAX_TIMEOUT = 1000;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(MAX_TIMEOUT - MIN_TIMEOUT);
        System.out.println(" . calculating: " + number);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            resultConsumer.add(number * number);
        }
    }
}
