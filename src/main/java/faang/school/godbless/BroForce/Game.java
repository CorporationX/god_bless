package faang.school.godbless.BroForce;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class Game {
    @Getter
    private int score;
    @Getter
    private int lostLives;
    private List<Player> players;
    //нет смысла делать несколько локов,
    //потому что оба счетчика блокируются и разблокируются
    //одновременно, поэтому в качестве лока this

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

    public synchronized void update() {
        if (players.isEmpty()) {//такое бывает только если игра уже проиграна,
            //или кто то решил сыграть без игроков
            System.err.println("There are no players");
            throw new IllegalArgumentException();
        }
        for (Player player : players) {
            if (100 * Math.random() < 50) {//типа повезло не повезло
                if (player.getLive() <= 1) {
                    gameOver(player);
                    return;
                } else {
                    player.setLive(player.getLive() - 1);
                    lostLives++;
                }
            }
        }
        score += players.size();
        System.out.println("updated");
    }

    private void gameOver(Player player) {
        System.out.println("player " + player.getName() + " died...");
        System.out.println("game over");
        players.clear();
    }
}
