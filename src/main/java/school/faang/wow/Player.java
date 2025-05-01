package school.faang.wow;

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

    public synchronized void addExperience(int experience) {
        this.experience += experience;
    }
}
