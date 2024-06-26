package faang.school.godbless.FanOutFanIn;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {
    @Getter
    private final AtomicLong sumOfSquaredNumbers;

    public ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
