package faang.school.godbless.fanInFanOut;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@RequiredArgsConstructor
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
