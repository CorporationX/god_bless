package faang.school.godbless.async.fanout;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
public class ResultConsumer {

    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public void add(final Long num) {
        sumOfSquaredNumbers.addAndGet(num);
    }
}
