package school.faang.sprint3.task49350broforce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private int maxScore;
    private List<Player> players = new ArrayList<>();
    private volatile boolean gameOn;

    private final Object lockeScore = new Object();
    private final Object lockeLives = new Object();
    private final Object lockeIsGame = new Object();

    Game(int maxScore) {
        this.maxScore = maxScore;
        this.gameOn = true;
    }

    public void addPlayers(List<Player> listPlayers) {
        players.addAll(listPlayers);
    }

    public void addPlayers(Player player) {
        players.add(player);
    }

    public void update(Player player, boolean earnedPoints, boolean lostLife) {
        if (earnedPoints) {
            synchronized (lockeScore) {
                if (!gameOn) {
                    return;
                }
                if (player.getScore() >= maxScore) {
                    System.out.println("Набрано максимальное количество очков");
                    gameOver();
                }
                maxScore++;
                player.earnPoints();
            }
        }
        if (lostLife) {
            synchronized (lockeLives) {
                if (!gameOn) {
                    return;
                }
                if (player.getLives() <= 0) {
                    gameOver();
                }
                player.loseLives();
            }
        }
    }

    public synchronized void gameOver() {
        if (!gameOn) {
            return;
        }
        Integer playerMaxScore = 0;
        String winnerPlayer = "";
        gameOn = false;

        for (Player player : this.getPlayers()) {
            if (player.getScore() > playerMaxScore && player.getLives() > 0) {
                playerMaxScore = player.getScore();
                winnerPlayer = player.getName();
            }
        }
        System.out.println("Игра окончена");
        System.out.printf("Победил %s со счётом %d", winnerPlayer, playerMaxScore);
    }
}