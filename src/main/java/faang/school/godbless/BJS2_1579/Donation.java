package faang.school.godbless.BJS2_1579;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@EqualsAndHashCode
public final class Donation {
    private static final AtomicInteger count = new AtomicInteger(1);
    private final int id = count.getAndIncrement();
    private final double amount;

    public Donation(double amount) {
        this.amount = amount;
    }
}