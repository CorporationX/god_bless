package faang.school.godbless.async.fanoutfanin;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public void add(final Long num) {
        sumOfSquaredNumbers.addAndGet(num);
    }

    public Long getFinal() {
        return sumOfSquaredNumbers.get();
    }
}
