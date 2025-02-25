package school.faang.sprint4.task63880;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExperience(int reward) {
        setExperience(getExperience() + reward);
    }
}
