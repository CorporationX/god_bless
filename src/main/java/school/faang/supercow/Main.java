package school.faang.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  private static final int THREAD_POOL_SIZE = 5;

  public static void main(String[] args) {
    List<Player> players = List.of(
        new Player("ShadowHunter"),
        new Player("DragonSlayer"),
        new Player("PixelWarrior"),
        new Player("MysticRogue"),
        new Player("FrostFire")
    );

    Boss boss = new Boss("Storm Master Astragor", 3);

    ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    for (Player player : players) {
      executorService.submit(() -> player.startBattle(boss));
    }

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e.getMessage());
    }

    executorService.submit(boss::killPlayer);
    Player leavedPlayer = players.get(0);
    if (boss.inFight(leavedPlayer)) {
      executorService.submit(() -> leavedPlayer.leaveBattle(boss));
    }

    executorService.shutdown();

    try {
      if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
        System.out.printf("поток %s дождался завершения всех потоков", Thread.currentThread().getName());
      } else {
        executorService.shutdownNow();
      }
    } catch (InterruptedException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }
}
