package faang.school.godbless.BJS2_5867;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    private final Object SCORE_LOCK = new Object();
    private int score;
    private final Object LIVES_LOCK = new Object();
    private int lives;
    final List<Player> players = new ArrayList<>();

    public void addNewPlayersInGame(Player player) {
        if (player != null) {
            players.add(player);
        } else {
            throw new IllegalArgumentException("player don't exist!");
        }
    }

    public void update() {
        while (true) {
            players.forEach(player -> {
                synchronized (SCORE_LOCK) {
                    if (player.isAlive()) {
                        score += player.getCurrentScore();
                        player.setCurrentScore(0);
                    }
                }
                synchronized (LIVES_LOCK) {
                    if (!player.isAlive()) {
                        lives += 1;
                    }
                }
            });
            if (lives == players.size()) {
                gameOver();
                break;
            }
        }
    }

    public void gameOver() {
        System.out.println("Total score = " + score);
        System.out.println("Total dies = " + lives);
        System.out.println("Game over");
    }
}
