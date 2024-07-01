package faang.school.godbless.Task_FanOut_FanIn;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer{

    private final AtomicLong sumOfSquaredNumbers;
    public ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }
    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
    public Long getValue() {
        return sumOfSquaredNumbers.longValue();
    }
}