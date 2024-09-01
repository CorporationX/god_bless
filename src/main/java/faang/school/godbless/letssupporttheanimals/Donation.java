package faang.school.godbless.letssupporttheanimals;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class Donation {
    private final String id;
    private final long amount;

    public Donation(long amount) {
        id = UUID.randomUUID().toString();
        this.amount = amount;
    }
}