package faang.school.godbless.superCar;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
  public static void main(String[] args) {
    Boss boss = new Boss(5);

    List<Player> players = List.of(
        new Player("Player 1"),
        new Player("Player 2"),
        new Player("Player 3"),
        new Player("Player 4"),
        new Player("Player 5"),
        new Player("Player 6")
    );

    ExecutorService executor = Executors.newFixedThreadPool(3);

    for (Player player : players) {
      player.startBattle(boss);
    }

    executor.shutdown();

    System.out.println("Finished");
  }
}
