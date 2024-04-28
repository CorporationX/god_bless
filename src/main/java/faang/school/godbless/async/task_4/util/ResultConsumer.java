package faang.school.godbless.async.task_4.util;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    public ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public Long get() {
        return sumOfSquaredNumbers.get();
    }
}