package fan_out_fan_in;

import java.util.concurrent.atomic.AtomicLong;

class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public Long getSumOfSquaredNumbers() {
        return sumOfSquaredNumbers.get();
    }
}
