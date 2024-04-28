package faang.school.godbless.async.task_4.math;

import faang.school.godbless.async.task_4.util.ResultConsumer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    private final long number;

    public void longTimeSquare(ResultConsumer resultConsumer) {
       int randomTimeout = ThreadLocalRandom.current().nextInt(1000);
       try {
           Thread.sleep(MIN_TIMEOUT + randomTimeout);
       } catch (InterruptedException e) {
           log.error(e.getMessage());
           e.printStackTrace();
       } finally {
           resultConsumer.add(number * number);
       }
    }
}