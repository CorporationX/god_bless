package faang.school.godbless.supportAnimals;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Donation {
    private final String id;
    private final int amount;

    public Donation(int amount) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
    }

}
