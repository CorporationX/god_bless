package school.faang.bjs274728;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Player {

    private String name;
    private int level;
    private int experience;

    public synchronized void addExperience(int experience) {
        this.experience += experience;
    }
}