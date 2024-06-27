package faang.school.godbless.Task_WoW;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        if (name.isBlank() || level <= 0 || experience < 0) throw new IllegalArgumentException("invalid args(s)");
        else {
            this.name = name;
            this.level = level;
            this.experience = experience;
        }
    }

}
