package faang.school.godbless.fan_out;

import java.util.concurrent.atomic.AtomicLong;

public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    public ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public long add(final Long num){
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public long getResult(){
        return sumOfSquaredNumbers.get();
    }
}
