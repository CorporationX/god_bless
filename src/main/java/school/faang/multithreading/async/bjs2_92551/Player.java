package school.faang.multithreading.async.bjs2_92551;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private int level;
    private int experience;

    public void updateExperience(int experience) {
        this.experience += experience;
    }
}