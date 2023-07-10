package faang.school.godbless.FanOutFanIn;

import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    public ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
