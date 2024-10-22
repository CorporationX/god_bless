package school.faang.BJS2_37138;

import lombok.Data;

import java.awt.image.ImagingOpException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
public class Game {
    private final Logger logger = Logger.getLogger(Game.class.getName());
    private int score = 0;
    private int lives = 100;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    Random rand = new Random();

    public void update(boolean attack) {
        synchronized (lockScore) {
            try {
                if (attack) {
                    score += rand.nextInt(6, 8);
                    System.out.print("Атака прошла успешно: ");
                    System.out.println("Текущий счет " + score);
                }
            } catch (ImagingOpException e) {
                logger.log(Level.SEVERE, "Ошибка начисления очков", e);
            }
        }

        synchronized (lockLives) {
            try {
                if (!attack) {
                    int damage = rand.nextInt(8, 9);
                    lives -= damage;
                    System.out.print("Атака не удалась: ");
                    if (lives <= 0 && lives < damage) {
                        System.out.println("HP: 0");
                        gameOver();
                    }
                    System.out.println("HP: " + lives);
                }
            } catch (ImagingOpException e) {
                logger.log(Level.SEVERE, "Ошибка снятия HP", e);
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over");
        System.out.println("Общий счет: " + score);
        System.exit(0);
    }
}
