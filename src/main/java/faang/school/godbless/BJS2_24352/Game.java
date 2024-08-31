package faang.school.godbless.BJS2_24352;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class Game {

    private int score;
    private int lives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public void update(Player attacker, Player defender) {
        int methodToInvoke = new Random().nextInt(2);
        if (methodToInvoke == 0) {
            attacker.dealsDamage(defender);
        } else {
            defender.dealsDamage(attacker);
        }
        synchronized (lockScore) {
            score++;
        }
        synchronized (lockLives){
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
