package faang.school.godbless.sprint2.fanOutFanIn;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Evgenii Malkov
 */
@Getter
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    public ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }
}
