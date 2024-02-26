package faang.school.godbless.broforce;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private boolean isOver;
    private long score;
    private long lostLives;
    private List<Bro> bros = new ArrayList<>();
    private final Object SCORE_LOCK = new Object();
    private final Object LIVES_LOCK = new Object();

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public void update() {
        Bro bro = bros.get((int) (Math.random() * bros.size()));
        if (bro.isAlive()) {
            synchronized (SCORE_LOCK) {
                score++;
                bro.setScore(bro.getScore() + 1);
            }
        } else {
            synchronized (LIVES_LOCK) {
                lostLives++;
                bro.setLives(bro.getLives() - 1);
                if (bro.getLives() <= 0) {
                    System.out.println(String.format("%s is dead...", bro.getName()));
                    gameOver();
                }
            }
        }
        System.out.println("Current score: " + score);
        System.out.println("Lost lives: " + lostLives);
        System.out.println();
    }

    public boolean isOver() {
        return isOver;
    }

    private void gameOver() {
        System.out.println("Game over");
        System.out.println("Total score: " + score);
        isOver = true;
    }
}
