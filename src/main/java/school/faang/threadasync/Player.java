package school.faang.threadasync;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Player {
    String name;
    int experience;
    int level;

    public void addExperience(int experience) {
        this.experience += experience;
    }
}
