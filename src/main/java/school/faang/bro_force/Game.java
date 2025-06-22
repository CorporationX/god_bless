package school.faang.bro_force;

import lombok.Getter;

public class Game {
    private int score = 0;
    @Getter
    private int lives = 10;

    private final Object lookOne = new Object();
    private final Object lookTwo = new Object();

    public void update(int score, int lives) {
        synchronized (lookOne) {
            if (score > 0) {
                this.score += score;
                System.out.println("Очки увеличены, текущий счёт на: " + score);
            }
        }
        synchronized (lookTwo) {
            if (lives > 0) {
                if (this.lives <= lives) {
                    gameOver();
                } else {
                    this.lives -= lives;
                    System.out.println("Жизни уменьшены, оставшиеся жизни: " + this.lives);
                }
            }
        }
    }

    private void gameOver() {
        System.out.printf("   КОНЕЦ ИГРЫ!\n  Всего очков: %d\n", score);
    }
}

