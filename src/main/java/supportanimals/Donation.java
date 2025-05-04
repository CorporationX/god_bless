package supportanimals;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Donation {
    private static final AtomicInteger UNIQUE_ID_COUNTER = new AtomicInteger(0);
    private int id;
    private double amount;

    public Donation(double amount) {
        this.id = UNIQUE_ID_COUNTER.incrementAndGet();
        this.amount = amount;
    }
}
