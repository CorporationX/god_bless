package school.faang.Multithreading.sprint_4.Wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private int level;
    int experience;

    public void addExperience(int experience){
        this.experience += experience;
    }
}
