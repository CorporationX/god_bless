package faang.school.godbless.multithreading.broforce;

import lombok.Getter;

public class Player {

    @Getter
    private final String name;

    private int score = 0;
    private int live;

    public Player(String name, int live) {
        this.live = live;
        this.name = name;
    }

    public void decreaseLive() {
        live -= 1;
    }

    public void increaseScore() {
        score += 1;
    }

    public boolean isAlive() {
        return live > 0;
    }

}
