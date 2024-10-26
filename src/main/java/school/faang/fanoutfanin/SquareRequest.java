package school.faang.fanoutfanin;

import java.util.concurrent.ThreadLocalRandom;

public class SquareRequest {
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(1000);
        try {
            Thread.sleep(randomTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            resultConsumer.add(number * number);
        }
    }
}
