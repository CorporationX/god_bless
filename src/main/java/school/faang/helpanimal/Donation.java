package school.faang.helpanimal;

import java.math.BigDecimal;
import java.util.UUID;

public record Donation(UUID id, BigDecimal amount) {
    public Donation(BigDecimal amount) {
        this(UUID.randomUUID(), amount);
    }
}
