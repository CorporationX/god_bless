package school.faang.m1s4.bjs2_40138_wwf;

import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@ToString
@Getter
public class Donation {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);
    private final int id;
    private final double amount;

    public Donation(double amount) {
        this.amount = amount;
        id = ID_COUNTER.incrementAndGet();
    }
}
