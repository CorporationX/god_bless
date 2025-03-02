package school.faang.supportanimals;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Donation {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    private final int id;
    private final BigDecimal amount;

    public Donation(BigDecimal amount) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.amount = amount;
    }
}
