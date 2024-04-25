package faang.school.godbless.BJS2_6108;

import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
public class ResultConsumer {
  private final AtomicLong sumOfSquaredNumbers;

  ResultConsumer(Long init) {
    sumOfSquaredNumbers = new AtomicLong(init);
  }

  public Long add(final Long num) {
    return sumOfSquaredNumbers.addAndGet(num);
  }
}
