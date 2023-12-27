package faang.school.godbless.fan;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public void add(Long num) {
        // идея сама предложила сделать метод void, и я не понял, зачем в задаче у него был тип
        sumOfSquaredNumbers.addAndGet(num);
    }
}
