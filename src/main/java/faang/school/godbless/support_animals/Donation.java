package faang.school.godbless.support_animals;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Donation {
    private static int startId = 0;
    private int id;
    private BigDecimal amount;

    public Donation(BigDecimal amount) {
        this.id = startId++;
        this.amount = amount;
    }
}