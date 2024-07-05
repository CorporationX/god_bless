package faang.school.godbless.future.fanOutFanIn;

import java.util.concurrent.ThreadLocalRandom;

public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    private static final int RANDOM_TIMEOUT = 1000;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(RANDOM_TIMEOUT);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " - " + number + " - total: "
                    + resultConsumer.getSumOfSquaredNumbers());
            resultConsumer.add(number * number);
        }
    }
}
