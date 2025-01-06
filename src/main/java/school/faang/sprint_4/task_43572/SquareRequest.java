package school.faang.sprint_4.task_43572;

import java.util.concurrent.ThreadLocalRandom;

public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    private static final int RANDOM_BOUND = 1000;

    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(RANDOM_BOUND);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван во время сна!");
        } finally {
            resultConsumer.add(number * number);
        }
    }
}

