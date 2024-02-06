package fanOutFanIn_1242;

import java.util.concurrent.ThreadLocalRandom;

public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public long longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(1000);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
            System.out.println("Посчитано число - " + number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return resultConsumer.add(number * number);
        }
    }
}
