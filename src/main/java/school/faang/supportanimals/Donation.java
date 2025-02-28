package school.faang.supportanimals;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Donation {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    private final int id;
    private final double amount;

    public Donation(double amount) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.amount = amount;
    }
}
