package school.faang.s_4_1_wow;

import java.util.concurrent.CompletableFuture;

public class Player {
    private final String name;
    private int level;
    private int experience;

    public Player(String name) {
        this.name = name;
        this.level = 0;
    }

    public String getName() {
        return name;
    }

    public synchronized Player increaseExperience(int score) {
        this.experience += score;
        System.out.println("Experience increased for the player " + this.name +
                ", experience at the moment: " + this.experience);
        return this;
    }

    public synchronized Player levelUp(int difficulty) {
        if (difficulty > this.level) {
            level += 1;
            System.out.println("Level's upped for the player " + this.name +
                    ", level now: " + this.level);
            return this;
        } else {
            return this;
        }
    }
}
