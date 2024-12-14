package school.faang.supercow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Boss {
  private final String name;
  private final int maxPlayers;
  private final Set<Player> players = new HashSet<>();

  public Boss(String name, int maxPlayers) {
    this.name = name;
    this.maxPlayers = maxPlayers;
  }

  public synchronized void joinPlayer(Player player) {
    if (maxPlayers == players.size()) {
      System.out.printf("все слоты заняты, игрок %s ждёт присоединения сражению с боссом %s\n", player.getName(), name);
      try {
        wait();
      } catch (InterruptedException e) {
        throw new IllegalStateException(e.getMessage());
      }
    }
    players.add(player);
    System.out.printf("игрок %s присоединился к сражению с боссом %s\n", player.getName(), name);
  }

  public synchronized void leavePlayer(Player player) {
    players.remove(player);
    System.out.printf("игрок %s покинул сражение с боссом %s\n", player.getName(), name);
    notify();
  }

  public synchronized boolean inFight(Player player) {
    return players.contains(player);
  }

  public synchronized void killPlayer() {
    List<Player> players = new ArrayList<>(this.players);
    Player killedPlayer = players.get(new Random().nextInt(players.size()));

    this.players.remove(killedPlayer);
    System.out.printf("игрок %s был убит боссом %s\n", killedPlayer.getName(), name);
    notify();
  }
}
