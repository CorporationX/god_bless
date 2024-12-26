package school.faang.sprint1.task_49341;

import lombok.Getter;

@Getter
public class Bro {

    private final String name;
    private final int live;
    private final int score;
    private final boolean isAlive;

    public Bro(String name, int live) {
        this.name = name;
        this.live = live;

        this.score = 0;
        this.isAlive = true;
    }

}
