package school.faang.bjs50087;

import lombok.Getter;

public class Player {
    @Getter
    private String name;
    private int level;
    @Getter
    private long experience;

    public Player(String name, int level) {
        this.name = name;
        this.level = level;
        experience = 0;
    }

    public synchronized void increaseExperience(int exp) {
        experience += exp;
    }
}
