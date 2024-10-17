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

    public void update(Player player) {
        synchronized (lockForLives) {
            int rand = random.nextInt(2+1);
            if(rand == 2) {
                score++;
                player.uppScore();
                System.out.println("Увеличиваем очки игрока " + player.getName());
            }
        }
        synchronized (lockForLives) {
            int rand = random.nextInt(4);
            if(rand <= 2) {
                System.out.println("Уменьшаем очки здоровья игрока " + player.getName());
                player.downHelth();
                if(player.checkLife()) {
                    latch.countDown();
                }
                lives++;
            }
        }
        if(latch.getCount() == 0) {
            System.out.println("Игра закончена");
            System.out.println(score);
            System.out.println(lives);
        }

    }
}
