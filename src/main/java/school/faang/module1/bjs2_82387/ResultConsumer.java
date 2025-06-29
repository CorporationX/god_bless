package school.faang.module1.bjs2_82387;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {

    private final AtomicLong sumOfSquaredNumbers;

    public ResultConsumer() {
        sumOfSquaredNumbers = new AtomicLong(0);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public Long getSum() {
        return sumOfSquaredNumbers.get();
    }
}