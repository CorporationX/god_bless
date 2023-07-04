package faang.school.godbless.superCar;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
      executor.submit(() -> player.startBattle(boss));
    }

    try {
      executor.awaitTermination(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    executor.submit(() -> players.get(0).finishBattle(boss));
    executor.submit(() -> players.get(1).finishBattle(boss));

    executor.shutdown();

    System.out.println("Finished");
  }
}
