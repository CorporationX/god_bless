package faang.school.godbless.Sprint_5.Multithreading_Async.FanInFanOut;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@AllArgsConstructor
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
