package school.faang.asynchrony.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addEx(Integer reward) {
        this.experience += reward;
    }
}
