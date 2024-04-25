package faang.school.godbless.async.fanOutFanIn;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public Long getSumOfSquaredNumbers() {
        return sumOfSquaredNumbers.get();
    }
}