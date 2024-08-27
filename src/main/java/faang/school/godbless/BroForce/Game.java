package faang.school.godbless.BroForce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class Game {
    @Getter
    private int score;
    @Getter
    private int lostLives;
    private Object scoreLock = new Object();
    private Object lostLivesLock = new Object();
    private List<Player> players;


    public Game(List<Player> players) {
        this.players = new ArrayList<>(players);

        score = 0;
        lostLives = 0;
    }


    public synchronized void setScore(int score) {
        this.score = score;
    }

    public synchronized void setLostLives(int lostLives) {
        this.lostLives = lostLives;
    }

    public void update() {
        if (players.isEmpty()) {//такое бывает только если игра уже проиграна,
            //или кто то решил сыграть без игроков
            System.err.println("There are no players");
            throw new IllegalArgumentException();
        }
        for (Player player : players) {
                if (100 * Math.random() < 50) {//типа повезло не повезло
                    synchronized (scoreLock) {
                        if (player.getLive() <= 1) {
                            gameOver(player);
                            return;
                        } else {
                            player.setLive(player.getLive() - 1);
                            lostLives++;
                        }
                    }
                } else {
                    synchronized (lostLivesLock) {
                        score++;
                    }
                }

        }
        System.out.println("updated");
    }

    private void gameOver(Player player) {
        System.out.println("player " + player.getName() + " died...");
        System.out.println("game over");
        players.clear();
    }
}
