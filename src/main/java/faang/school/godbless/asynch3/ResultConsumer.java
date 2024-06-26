package faang.school.godbless.asynch3;

import java.util.concurrent.atomic.AtomicLong;

public record ResultConsumer(AtomicLong sumOfSquaredNumbers) {
    public ResultConsumer(Long init) {
        this(new AtomicLong(init));
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
