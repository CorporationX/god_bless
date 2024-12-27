package school.faang.sprint3.task49350broforce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private int maxScore;
    private List<Player> players = new ArrayList<>();
    private volatile boolean isGame;

    private final Object lockeScore = new Object();
    private final Object lockeLives = new Object();
    private final Object lockeIsGame = new Object();

    Game(int maxScore) {
        this.maxScore = maxScore;
        this.isGame = true;
    }

    public void addPlayers(List<Player> listPlayers) {
        players.addAll(listPlayers);
    }

    public void addPlayers(Player player) {
        players.add(player);
    }

    public void update(Player player, boolean earnedPoints, boolean lostLife) {
        if (!isGame) {
            return;
        }
        synchronized (lockeScore) {
            synchronized (lockeIsGame) {
                if (earnedPoints) {
                    maxScore++;
                    player.scoredPoints();
                    if (player.getScore() >= maxScore) {
                        gameOver();
                    }
                }
            }
        }
        synchronized (lockeLives) {
            synchronized (lockeIsGame) {
                if (lostLife) {
                    player.loseLives();
                    if (player.getLives() <= 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    public synchronized void gameOver() {
        System.out.println("Игра окончена");
        Integer playerMaxScore = 0;
        String winnerPlayer = "";

        for (Player player : this.getPlayers()) {
            if (player.getScore() > playerMaxScore) {
                playerMaxScore = player.getScore();
                winnerPlayer = player.getName();
            }
        }
        isGame = false;
        System.out.printf("Победил %s со счётом %d %n", winnerPlayer, playerMaxScore);
    }
}