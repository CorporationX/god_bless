package faang.BJS2_74628;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Player {
    private final String name;
    private final int level;

    private int experience;

    public synchronized void increaseExperience(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(amount + " experience cannot be less or equals than 0");
        }

        this.experience += amount;
    }
}
