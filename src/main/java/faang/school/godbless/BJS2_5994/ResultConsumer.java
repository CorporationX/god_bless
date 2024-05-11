package faang.school.godbless.BJS2_5994;

import java.util.concurrent.atomic.AtomicLong;


public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long getSumOfSquaredNumbers() {
        return sumOfSquaredNumbers.get();
    }

    public void add(final Long num) {
        sumOfSquaredNumbers.addAndGet(num);
    }
}
