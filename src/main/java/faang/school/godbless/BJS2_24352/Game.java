package faang.school.godbless.BJS2_24352;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Game {

    private int score;
    private int lives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public void update(Player attacker, Player defender) {
        boolean damageTaken = Math.random() < 0.5;
        Player.getDamage(damageTaken ? attacker : defender);
        synchronized (lockScore) {
            score++;
        }
        if (attacker.getLives() == 0 || defender.getLives() == 0) {
            gameOver();
        } else {
            synchronized (lockLives) {
                lives++;
            }
        }
    }

    public void gameOver() {
        System.out.println("GAME is OVER");
    }
}
