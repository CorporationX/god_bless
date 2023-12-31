package faang.school.godbless.multithreading_async.fan_out_fan_in;

import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
