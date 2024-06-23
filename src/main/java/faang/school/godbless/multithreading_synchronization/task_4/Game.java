package faang.school.godbless.multithreading_synchronization.task_4;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int score = 0;
    private int lives = 0;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final List<Bro> bros = new ArrayList<>();

    public void update(Bro bro) {
        while (isEveryoneAlive()) {
            if (bro.won()) {
                synchronized (scoreLock) {
                    score++;
                    bro.setScore(bro.getScore() + 1);
                }
            } else {
                synchronized (livesLock) {
                    lives++;
                    bro.setLives(bro.getLives() - 1);
                    System.out.println("Player: " + bro.getName() + " lives: " + bro.getLives());
                    if (bro.isBroAlive()) {
                        gameOver();
                    }
                }
            }
        }
    }

    public void gameOver() {
        System.out.println("Game over with max score: " + score);
        System.out.println("Lost lives: " + lives);
    }

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    private boolean isEveryoneAlive() {
        synchronized (livesLock) {
            return bros.stream().allMatch(bro -> bro.getLives() > 0);
        }
    }
}
