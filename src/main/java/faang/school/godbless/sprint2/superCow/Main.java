package faang.school.godbless.sprint2.superCow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Evgenii Malkov
 */
public class Main {

  private static final int POOL_SIZE = 10;
  public static void main(String[] args) {
    Boss boss = new Boss();
    ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
    List<Player> players = getPlayers();

    for (Player player : players) {
      executor.submit(() -> player.startBattle(boss));
    }

    executor.shutdown();
  }

  public static List<Player> getPlayers() {
    return IntStream.range(0, POOL_SIZE)
        .mapToObj((i) -> new Player("Player " + i))
        .toList();
  }
}
