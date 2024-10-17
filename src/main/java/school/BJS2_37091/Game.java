package school.BJS2_37091;

import lombok.Getter;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

@Getter
public class Game {

    private int score;
    private int lives;
    private volatile CountDownLatch latch;

    public Game(CountDownLatch latch) {
        this.latch = latch;
    }

    private Object lockForScore = new Object();
    private Object lockForLives = new Object();
    Random random = new Random();

    public void update(Player player) throws InterruptedException {
        synchronized (lockForScore) {
            int rand = random.nextInt(3);
            if (player.checkLife()) {
                if (rand == 2) {
                    score++;
                    player.uppScore();
                    System.out.println("Увеличиваем очки игрока " + player.getName());
                }
            }
        }
        synchronized (lockForLives) {
            int rand = random.nextInt(6);
            if (rand <= 2) {
                if (player.checkLife()) {
                    player.downHelth();
                    System.out.println("Уменьшаем очки здоровья игрока " + player.getName() + ". Здоровье равно: " + player.getHelth());
                    lives++;
                } else if (player.getHelth() == 0) {
                    player.downHelth();
                    System.out.println("Выбывает игрок " + player.getName());
                    latch.countDown();
                }
            }
        }
    }

    public void endGame() {
        System.out.println("Игра закончена");
        System.out.println("Общее число набранных очков: " + score);
        System.out.println("Общее число потерянных жизней жизней: " + lives);
    }
}
