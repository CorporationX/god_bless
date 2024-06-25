package faang.school.godbless.BJS2_13548;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        this.sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }

}
