package faang.school.godbless.task.multithreading.async.fanout.fanin;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class SquareRequest {
    private static final int MIN_TIMEOUT = 3000;
    private static final int TIMEOUT_RANGE = 1000;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(TIMEOUT_RANGE);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            resultConsumer.add(number * number);
        }
    }
}
