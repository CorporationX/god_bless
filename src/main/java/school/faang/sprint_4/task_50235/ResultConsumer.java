package school.faang.sprint_4.task_50235;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        if (num < 0) {
            throw new IllegalArgumentException("Число не может быть null");
        }
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public Long getSum() {
        return sumOfSquaredNumbers.get();
    }
}
