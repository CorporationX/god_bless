package faang.school.godbless.BJS2_25100;

import lombok.AllArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    private final long number;

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(1000);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Вычислен квадрат числа: " + number);
            resultConsumer.add(number * number);
        }
    }
}
