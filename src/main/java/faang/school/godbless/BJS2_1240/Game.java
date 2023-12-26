package faang.school.godbless.BJS2_1240;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final Random random = new Random();
    private List<Player> players;
    private int score;
    private int lives;
    private boolean isAnyoneDead = false;

    public Game(List<Player> players) {
        this.players = players;
    }

    public void update() {

        while (!isAnyoneDead) {
            int playerIndex = random.nextInt(players.size());
            Player player = players.get(playerIndex);
            boolean isAlive = player.isAlive();
            if (isAlive) {
                synchronized (scoreLock) {
                    player.upScore();
                    this.score++;
                }
            } else {
                synchronized (livesLock) {
                    player.downLives();
                    this.lives++;
                    if (player.getLives() == 0) {
                        gameOver();
                        this.isAnyoneDead = true;
                    }
                }
            }

            System.out.println(Thread.currentThread() + " " + player.getName() + " updated. Player score: " + player.getScore() + ", Player lives: " + player.getLives());
            System.out.println(Thread.currentThread() + " General " + "Score: " + score + ", Lives: " + lives);

        }
    }

    private void gameOver() {
        System.out.println("game over!");
    }
}