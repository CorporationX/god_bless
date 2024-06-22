package faang.school.godbless.bjs2_12541;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {

  private static final int POOL_SIZE = 10;
  private static final int LIMIT_PLAYERS = 150;
  private static final int MAX_PLAYER_POWER = 10;
  private static final long TIME_OUT = 50;
  private static final int PLAYER_COUNT = 5;

  public static void main(String[] args) {
    Boss boss = new Boss(UUID.randomUUID().toString(), PLAYER_COUNT);

    ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

    Stream.generate(() -> new Player(UUID.randomUUID().toString(), new Random().nextInt(MAX_PLAYER_POWER)))
        .limit(LIMIT_PLAYERS)
        .forEach(player -> executorService.submit(() -> player.startBattle(boss)));

    executorService.shutdown();

    try {
      executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
