package school.faang.multithreading.synchron.bro.force;

import lombok.SneakyThrows;

public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(int lives) {
        this.lives = lives;
    }

    @SneakyThrows
    public void update(boolean increaseScore, boolean reduceLive) {
        if (increaseScore) {
            synchronized (scoreLock) {
                if (lives == 0) {
                    return;
                }
                score++;
                System.out.println("Победа! Ваш счет: " + score);
            }
        }

        if (reduceLive) {
            synchronized (livesLock) {
                if (lives > 0) {
                    lives--;
                    System.out.println("Потеряна жизнь. Осталось жизней: " + lives);
                    if (lives == 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Игра окончена. Ваш финальный счет: " + score);
    }
}
