package school.faang.bjs2_92615;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public synchronized void addExperience(int increasingExperience) {
        this.experience += increasingExperience;
    }
}