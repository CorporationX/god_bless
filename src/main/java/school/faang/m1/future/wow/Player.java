package school.faang.m1.future.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private final String name;
    private int level;
    private int experience;


    public void gainExperience(int experience) {
        this.experience += experience;
    }

    public void levelUpIfNeeded(int experience) {
        int levels = experience / 300;
        if (levels > 0) {
            this.level = levels;
        }
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', level=" + getLevel() + ", xp=" + getExperience() + "}";
    }
}
