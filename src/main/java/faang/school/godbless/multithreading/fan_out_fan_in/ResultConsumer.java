package faang.school.godbless.multithreading.fan_out_fan_in;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {
    @Getter
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
