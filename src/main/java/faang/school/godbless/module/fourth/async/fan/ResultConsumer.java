package faang.school.godbless.module.fourth.async.fan;

import java.util.concurrent.atomic.AtomicLong;

import lombok.Getter;

@Getter
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;
    
    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }
    
    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
