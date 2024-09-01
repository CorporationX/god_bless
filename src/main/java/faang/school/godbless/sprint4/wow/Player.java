package faang.school.godbless.sprint4.wow;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(exclude = "EXP_PER_LEVEL")
public class Player {
    private final int EXP_PER_LEVEL = 5000;
    private String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        if (experience > EXP_PER_LEVEL) {
            throw new IllegalArgumentException("Exp can't be greater than maximum exp per level!");
        }
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public void gainExperience(int experience) {
        int totalExperience = experience + this.experience;
        int quotient = totalExperience / EXP_PER_LEVEL;

        if (quotient == 0) {
            this.experience = totalExperience;
        } else {
            this.experience = totalExperience - quotient * EXP_PER_LEVEL;
            this.level += quotient;
        }
    }
}
