package faang.school;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {
    @Getter
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public void add(final Long num) {
        sumOfSquaredNumbers.addAndGet(num);
    }
}


