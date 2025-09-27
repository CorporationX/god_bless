package school.faang.bjs2_92561;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public synchronized void addExperience(int exp) {
        this.experience += exp;
    }
}