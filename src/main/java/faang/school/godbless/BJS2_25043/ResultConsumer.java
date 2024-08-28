package faang.school.godbless.BJS2_25043;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    public Long getSum() {
        return sumOfSquaredNumbers.get();
    }

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
