package faang.school.godbless.kxnvg.fanout;

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
