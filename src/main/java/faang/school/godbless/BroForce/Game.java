package faang.school.godbless.BroForce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private static final Random random = new Random();

    @Getter
    private List<Player> players = new ArrayList<>();

    private int score;
    private int lives;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public synchronized void update() {
        while (isAllAlive()) {
            int playerIndex = random.nextInt(players.size());
            Player player = players.get(playerIndex);

            System.out.print(player.getName() + " attacks!...  ");

            if (player.won()) {
                synchronized (scoreLock) {
                    player.setScore(player.getScore() + 1);
                    System.out.println("won! score: " + player.getScore());
                    this.score++;
                }
            } else {
                synchronized (livesLock) {
                    player.setLives(player.getLives() - 1);
                    System.out.println("lose( lives: " + player.getLives());
                    this.lives++;
                    if (player.getLives() == 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    private synchronized void gameOver() {
        System.out.println("Total score " + score);
        System.out.println("Total lives " + lives);
    }

    public boolean isAllAlive() {
        synchronized (livesLock) {
            return players.stream().allMatch((player) -> player.getLives() > 0);
        }
    }

    public Game(List<Player> players) {
        this.players = players;
    }
}