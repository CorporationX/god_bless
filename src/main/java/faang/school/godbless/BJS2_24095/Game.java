package faang.school.godbless.BJS2_24095;

import java.util.List;

public class Game {
    private int score;
    private int lives;

    private Object scoreLock = new Object();
    private Object livesLock = new Object();
    private List<Bro> bros;

    public void update() {

    }

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    private void gameOver() {

    }

}
