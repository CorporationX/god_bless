package faang.school.godbless.fanOutFanIn;

import java.util.concurrent.ThreadLocalRandom;

public record SquareRequest(Long number) {
    private static final long MIN_TIMEOUT = 3000L;

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
