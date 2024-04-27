package faang.school.godbless.BJS2_6037;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {
    protected final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
