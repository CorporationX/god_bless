package faang.school.godbless.module.fourth.async.fan;

import java.util.concurrent.ThreadLocalRandom;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SquareRequest {
    private static final long MIN_TIMEOUT = 10L;
    private final Long number;
    
    public SquareRequest(Long number) {
        this.number = number;
    }
    
    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(100);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log.info("Добавляем квадрат числа {}", number);
            resultConsumer.add(number * number);
        }
    }
}
