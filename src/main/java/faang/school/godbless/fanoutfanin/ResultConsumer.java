package faang.school.godbless.fanoutfanin;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    public ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
