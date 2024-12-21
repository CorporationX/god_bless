package school.faang.bro_force;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int score;
    private int lives;
    private final List<Player> alivePlayers = new ArrayList<>();
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final Object alivePlayersLock = new Object();

    public void update(Action action, Player player) {
        if (!alivePlayers.contains(player)) {
            System.out.println("Player not found");
        }
        switch (action) {
          case PLAYER_SCORE_UP -> {
              synchronized (scoreLock) {
                  score++;
                  System.out.println(player + " got score. TotalScore = " + score);
              }
          }
          case PLAYER_WAS_ATTACKED -> {
              synchronized (livesLock) {
                  lives--;
                  System.out.println(player + " got damage. Player lives = "
                          + player.getHp() + " TotalLives = " + lives);
              }
              player.losingHp();
              if (player.getHp() == 0) {
                  update(Action.PLAYER_DIED, player);
                  System.out.println(player + " got damage. Player died. AlivePlayers = " + alivePlayers);
              }
              if (alivePlayers.isEmpty()) {
                  gameOver();
              }
          }
          case PLAYER_JOIN -> {
              synchronized (livesLock) {
                  lives += player.getHp();
              }
              synchronized (alivePlayersLock) {
                  alivePlayers.add(player);
                  System.out.println(player + " joined.");
              }
          }
          case PLAYER_DIED -> {
              synchronized (alivePlayersLock) {
                  alivePlayers.remove(player);
                  System.out.println(player + " died. AlivePlayers = " + alivePlayers);
              }
          }
          default -> {
              System.out.println();
          }
        }
    }

    public void update(Action action, Player player, int countRepeat) {
        for (int i = 1; i <= countRepeat; i++) {
            update(action, player);
        }
    }

    public void gameOver() {
        System.out.println("GAME OVER");
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }

    public List<Player> getAlivePlayers() {
        return alivePlayers;
    }
}