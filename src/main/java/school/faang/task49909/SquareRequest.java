package school.faang.task49909;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public record SquareRequest(Long number) {
    private static final long MIN_TIMEOUT = 3000L;
    private static final int RANDOM_TIME = 1000;

    public ResultConsumer longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(RANDOM_TIME);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Возникла ошибка при добавлении квадрата числа", e);
        } finally {
            resultConsumer.add(number * number);
        }
        return resultConsumer;
    }
}
