package BJS2_6017;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private int score;
    private int lives;
    private Object liveLock = new Object();
    private Object scoreLock = new Object();
    private List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean update() {
        Player player = players.get(new Random().nextInt(players.size()));
        synchronized (liveLock) {
            player.setLives(player.getLives() - 1);
            lives++;
            if (player.getLives() == 0) {
                System.out.println(player.getName() + " мертв");
                return false;
            }
        }
        synchronized (scoreLock) {
            score++;
        }
        return true;
    }

    public void gameOver() {
        System.out.println("Очки " + score);
        System.out.println("Жизни " + lives);
    }
}
