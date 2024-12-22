package school.faang.sprint3.bjs_49320;

import lombok.Getter;

@Getter
public class Game {
    private int score;
    private int lives;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game() {
        this.score = 0;
        this.lives = 6;
    }

    public void update(boolean isScorePointGot, boolean isLivePointLost) {
        synchronized (scoreLock) {
            if (isScorePointGot) {
                score++;
                System.out.println("Получено 1 очко. Текущий счет: " + score + " очков");
            }
        }

        synchronized (livesLock) {
            if (isLivePointLost) {
                lives--;
                System.out.println("Вы потеряли 1 жизнь. Осталось жизней: " + lives);
            }

            if (lives == 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        System.out.println("Конец игры. Вы набрали: " + score + " очков");
    }
}
