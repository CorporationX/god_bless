package school.faang.module1.sprint4.wow;

import lombok.Data;

@Data
public class Player {
    private final String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }
}