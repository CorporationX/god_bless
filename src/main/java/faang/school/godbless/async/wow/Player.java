package faang.school.godbless.async.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@AllArgsConstructor
@Getter
@Setter
public class Player {
    private String name;
    private int level;
    private int experience;

    public synchronized Player addExperience(int experience) {
        this.experience += experience;
        return this;
    }
}
