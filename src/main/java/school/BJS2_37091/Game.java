package school.BJS2_37091;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Game {

    private int score;
    private int lives;
    private CountDownLatch latch;
    private Object lockForScore = new Object();
    private Object lockForLives = new Object();
    private Random random = new Random();

    public Game(CountDownLatch latch) {
        this.latch = latch;
    }

    public boolean update(Player player) {
        synchronized (lockForScore) {
            if (random.nextBoolean()) {
                score++;
                player.uppScore();
                System.out.println("Увеличиваем очки игрока " + player.getName());
            }
        }
        synchronized (lockForLives) {
            if (random.nextBoolean()) {
                System.out.println("Уменьшаем очки здоровья игрока " + player.getName() + ". Здоровье равно: " + player.getHelth());
                player.downHelth();
                lives++;
                if (player.checkLife()) {
                    System.out.println("Выбывает игрок " + player.getName());
                    latch.countDown();
                    return true;
                }
            }
        }
        return false;
    }

    public void endGame() {
        System.out.println("Конец игры");
        System.out.println("Общее количество набранных очков: " + score);
        System.out.println("Общее количество потерянных жизней: " + lives);
    }
}