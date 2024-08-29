package faang.school.godbless;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        log.info("add " + num);
        return sumOfSquaredNumbers.addAndGet(num);
    }
    public Long getCopy(){
        return sumOfSquaredNumbers.get();
    }
}