package faang.school.godbless.donations;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Donation {
    private final String id;
    private final int amount;

    public Donation(int amount) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
    }
}

