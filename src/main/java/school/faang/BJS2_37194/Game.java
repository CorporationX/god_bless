package school.faang.BJS2_37194;

public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean scored, boolean lostLife) {
        synchronized (scoreLock) {
            if (scored) {
                score++;
                System.out.println("Очки увеличены. Текущий счёт: " + score);
            }
        }

        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                System.out.println("Жизнь потеряна. Осталось жизней: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Игра окончена. Итоговый счёт: " + score);
    }

    public void startGame() {
        for (int i = 0; i < 100; i++) {
            boolean scored = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.7;

            update(scored, lostLife);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Игровой цикл был прерван.");
                e.printStackTrace();
            }

            if (lives <= 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}

