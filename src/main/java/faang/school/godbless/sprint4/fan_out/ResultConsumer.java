package faang.school.godbless.sprint4.fan_out;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {
    final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
