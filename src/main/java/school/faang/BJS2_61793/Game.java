package school.faang.BJS2_61793;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Game {
    private static final int GAME_ENDING_LIVES = 0;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    private int score;
    private int lives;

    public void update(boolean addPoint, boolean loseLife) {
        if (addPoint) {
            synchronized (lockScore) {
                score++;
                System.out.printf("Добавлено очко. Всего: %d\n", score);
            }
        }
        if (loseLife) {
            synchronized (lockLives) {
                lives--;
                System.out.printf("Вы потеряли жизнь! Осталось: %d\n", lives);
                if (lives <= GAME_ENDING_LIVES) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.printf("Игра закончена! Кол-во заработанных очков: %d\n", score);
        System.exit(0);
    }
}
