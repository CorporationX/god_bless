package faang.school.godbless.BJS2_5968;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
  private static final int NUM_THREADS = 2;

  public static void main(String[] args) {
    Boss boss = new Boss(2);
    ExecutorService executors = Executors.newFixedThreadPool(NUM_THREADS);

    Player p1 = new Player("p1");
    Player p2 = new Player("p2");
    Player p3 = new Player("p3");
    Player p4 = new Player("p4");
    Player p5 = new Player("p5");

    executors.execute(() -> p1.startBattle(boss));
    executors.execute(() -> p2.startBattle(boss));
    executors.execute(() -> p3.startBattle(boss));
    executors.execute(() -> p4.startBattle(boss));
    executors.execute(() -> p5.startBattle(boss));

    executors.shutdown();
  }
}
