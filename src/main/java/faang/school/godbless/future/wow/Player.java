package faang.school.godbless.future.wow;

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

    public synchronized Player addExperience(int experience) {
        this.experience += experience;
        return this;
    }
}
