package school.faang.bjs2_90222;

import lombok.Getter;

@Getter
public class Game {
    private int score = 0;
    private int lives = 100;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean hasScored, boolean lostLife) {
        synchronized (scoreLock) {
            if (hasScored) {
                score++;
                System.out.printf("Очки увеличены. Текущий счет: %d.%n", score);
            }
        }

        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                System.out.printf("Жизни уменьшены. Осталось жизней: %d.%n", lives);
                if (lives == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.printf("Игра окончена. Игрок набрал %d очков.", score);
    }
}
