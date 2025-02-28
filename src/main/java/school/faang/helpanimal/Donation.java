package school.faang.helpanimal;

import java.util.UUID;

public record Donation(UUID id, int amount) {
    public Donation(int amount) {
        this(UUID.randomUUID(), amount);
    }
}
