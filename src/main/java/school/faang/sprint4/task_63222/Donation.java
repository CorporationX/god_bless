package school.faang.sprint4.task_63222;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@ToString
public class Donation {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
    private final int id = ID_GENERATOR.incrementAndGet();
    @Getter
    private final BigDecimal amount = new BigDecimal(100);

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Donation donation = (Donation) o;
        return id == donation.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
