package faang.school.godbless.BJS2_24352;

import lombok.Getter;

import java.util.Random;

@Getter
public class Game {

    private int score;
    private int lives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    private int methodToInvoke;

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    public void update(Player attacker, Player defender) {
        methodToInvoke = new Random().nextInt(2);
        if (methodToInvoke == 0) {
            attacker.dealsDamage();
        } else {
            defender.dealsDamage();
        }
        synchronized (lockScore) {
            score++;
        }
        synchronized (lockLives) {
            if (attacker.getLives() == 0 || defender.getLives() == 0) {
                gameOver();
            } else {
                lives++;
            }
        }
    }

    public void gameOver() {
        System.out.println("GAME is OVER");
    }
}
