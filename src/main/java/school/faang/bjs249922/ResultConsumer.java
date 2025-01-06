package school.faang.bjs249922;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@RequiredArgsConstructor
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public Long getSum() {
        return sumOfSquaredNumbers.get();
    }
}