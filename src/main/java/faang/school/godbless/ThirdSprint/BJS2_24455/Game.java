package faang.school.godbless.ThirdSprint.BJS2_24455;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private final Object livesLock = new Object();
    private final Object scoreLock = new Object();
    private int score;
    private int lives;
    private List<Bro> bros = new ArrayList<>();

    public void update() {
        for (Bro bro : bros) {
            int currentStats = bro.getCurrentStat();
            if (currentStats == 0) {
                updateLives(bro);
                System.out.println(bro.getName() + "have been killed current lives: " + bro.getLives());
                if (bro.getLives() == 0) {
                    gameOver();
                    break;
                }
            } else {
                updateScore(bro, currentStats);
            }
        }
    }

    public void updateLives(Bro bro) {
        synchronized (livesLock) {
            bro.setLives(bro.getLives() - 1);
            lives++;
        }
    }

    public void updateScore(Bro bro, int score) {
        synchronized (scoreLock) {
            System.out.println(bro.getName() + " killed: " + score + " enemies");
            this.score += score;
        }
    }

    public void gameOver() {
        System.out.println("Game Over !!!");
        System.out.println("lives spent " + lives);
        System.out.println("total score " + score);
    }
}
