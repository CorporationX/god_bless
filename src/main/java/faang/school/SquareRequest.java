package faang.school;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    @NonNull
    private final Long number;

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(1000);
        try {
//            Thread.sleep(MIN_TIMEOUT + randomTimeout);
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            resultConsumer.add(number * number);
        }
    }
}
