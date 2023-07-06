package faang.school.godbless.spring_4.fan_out_fan_in;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    public ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public AtomicLong getSumOfSquaredNumbers() {
        return sumOfSquaredNumbers;
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
