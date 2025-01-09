package school.faang.task_49685;

public class Game {
    private int score;
    private int lives;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean gainedScore, boolean lostLife) {
        // Обновление счёта
        if (gainedScore) {
            synchronized (scoreLock) {
                score++;
                System.out.println("Score updated: " + score);
            }
        }

        // Обновление количества жизней
        if (lostLife) {
            synchronized (livesLock) {
                lives--;
                System.out.println("Lives updated: " + lives);

                // Проверка, не закончились ли жизни
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game Over! Final Score: " + score);
        // Здесь можно добавить дополнительные действия при завершении игры
        System.exit(0); // Завершение программы
    }

    public static void main(String[] args) {
        Game game = new Game();

        // Симуляция игрового процесса
        for (int i = 0; i < 10; i++) {
            boolean gainedScore = Math.random() > 0.5; // 50% шанс на получение очков
            boolean lostLife = Math.random() > 0.7;   // 30% шанс на потерю жизни

            // Обновление состояния игры
            game.update(gainedScore, lostLife);

            try {
                Thread.sleep(500); // Задержка для имитации времени между обновлениями
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Game simulation completed.");
    }
}
