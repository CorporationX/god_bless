package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Player {
    private String name;
    private int level;
    private int experience;

    public synchronized void addExperience(int amount) {
        this.experience += amount;
    }

    public synchronized int getExperience() {
        return experience;
    }
}
