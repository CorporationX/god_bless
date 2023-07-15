package faang.school.godbless.fan_out_fan_in;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;
@Getter
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
