package school.faang.sprint_4.task_50235;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class SquareRequest {
    private static final long MIN_TIMEOUT = 300L;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        if (resultConsumer == null) {
            log.error("Потребить не может быть null");
        }
        var randomTimeout = ThreadLocalRandom.current().nextInt(100);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            resultConsumer.add(number * number);
        }
    }
}
