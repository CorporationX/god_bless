package faang.school.godbless.BJS2_13560;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    // добавляет квадрат к общей сумме
    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}