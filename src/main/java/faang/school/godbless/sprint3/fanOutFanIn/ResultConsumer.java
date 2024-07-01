package faang.school.godbless.sprint3.fanOutFanIn;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {

    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public long get() {
        return sumOfSquaredNumbers.get();
    }
}
