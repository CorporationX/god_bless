package school.faang.BJS2_37194;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {
    private int score = 0;
    private int lives = 10;
    private boolean isGameOver = false;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean scored, boolean lostLife) {
        if (isGameOver) {
            return;
        }

        if (scored) {
            synchronized (scoreLock) {
                score++;
                System.out.println("Очки увеличены. Текущий счёт: " + score);
            }
        }

        if (lostLife) {
            synchronized (livesLock) {
                lives--;
                System.out.println("Жизнь потеряна. Осталось жизней: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        System.out.println("Game Over. Score: " + score);
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void startGame() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                while (!isGameOver()) {
                    boolean scored = Math.random() > 0.5;
                    boolean lifeLost = Math.random() > 0.7;
                    update(scored, lifeLost);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Game interrupted.");
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}

