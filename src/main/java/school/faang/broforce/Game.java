package school.faang.broforce;

import java.util.concurrent.locks.ReentrantLock;

public class Game {
    private int score = 0;
    private int lives = 0;

    private final ReentrantLock scoreLock = new ReentrantLock();
    private final ReentrantLock livesLock = new ReentrantLock();

    private static boolean gameIsOn = true;

    public static boolean isGameIsOn() {
        return gameIsOn;
    }

    public void update(Player player) {
        if (player.getHealth() == 30) {
            scoreLock.lock();
            try {
                score++;
                System.out.println("Игрок " + player.getName() + " набрал очко. Общий счет: " + score);
            } finally {
                scoreLock.unlock();
            }
        }

        if (player.getLives() < 5 && player.getHealth() == 30) {
            livesLock.lock();
            try {
                lives++;
                System.out.println("Игрок " + player.getName() + " потерял жизнь. Потеряно жизней: " + lives);
            } finally {
                livesLock.unlock();
            }
        }
    }

    public void gameOver(Player player) {
        System.out.println("Игра завершена. Игрок " + player.getName() + " потерял все жизни.");
        System.out.println("Общее количество потерянных жизней: " + lives);
        System.out.println("Общий счет: " + score);
        gameIsOn = false;
    }
}
