package faang.school.godbless.sprint5.Multithreading_Async.task5_fanout_fanin;

import lombok.ToString;

import java.util.concurrent.ThreadLocalRandom;

@ToString
public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(1000);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            resultConsumer.add(number * number);
        }
    }
}
