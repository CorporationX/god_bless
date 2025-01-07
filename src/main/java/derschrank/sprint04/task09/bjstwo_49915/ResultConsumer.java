package derschrank.sprint04.task09.bjstwo_49915;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    public ResultConsumer() {
        this(0L);
    }

    public ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }


    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public Long getSum() {
        return sumOfSquaredNumbers.get();
    }
}

