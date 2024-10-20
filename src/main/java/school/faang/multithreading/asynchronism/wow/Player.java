package school.faang.multithreading.asynchronism.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExperience(Integer reward) {
        experience += reward;
    }
}
