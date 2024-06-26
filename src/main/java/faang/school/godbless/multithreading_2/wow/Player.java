package faang.school.godbless.multithreading_2.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Player {
    @Getter
    private String name;
    private int level;
    @Getter
    private int experience;

    public void increaseExperience(int experience) {
        this.experience += experience;
    }
}
