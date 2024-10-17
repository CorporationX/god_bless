package school.BJS2_37091;

import lombok.Getter;

@Getter
public class Player {

    private Game game;
    @Getter
    private String name;
    private int helth;
    private int score;

    public Player(String name, int helth, int score) {
        this.name = name;
        this.helth = helth;
        this.score = score;
    }

    public void uppScore() {
        score++;
    }

    public void downHelth() {
        helth--;

    }

    public boolean checkLife() {
        if (helth > 0) {
            return true;
        } else return false;
    }
}
