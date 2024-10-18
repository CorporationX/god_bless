package mod1sp3.broForce;

import lombok.Data;

@Data
public class Game {
    private int score = 0;
    private int lives = 10;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private boolean isGameStarted = true;

    public void update(boolean getScore, boolean lostLive) {
        synchronized (scoreLock) {
            if (getScore) {
                score++;
                System.out.println("Вы получили очко +1, всего очков: " + score);
            }
        }
        synchronized (livesLock) {
            if (lostLive) {
                if (lives > 0) {
                    lives--;
                    System.out.println("Вы потеряли жизнь, всего жизней осталось: " + lives);
                } else {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Игра окончена, всего набрано очков: " + score);
        isGameStarted = false;
    }
}
