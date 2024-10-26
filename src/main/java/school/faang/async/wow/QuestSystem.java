package school.faang.async.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuestSystem {

  public static final int MAX_WAITING_TIME = 5;

  public CompletableFuture<Player> startQuest(Player player, Quest quest,
      ExecutorService questExecutor) {
    return CompletableFuture.supplyAsync(() -> {
      try {
        log.info("get into: {}", quest.getName());
        System.out.println(player + " starting " + quest + " >>>");
        Thread.sleep(player.getLevel() * 100L);
        player.experienceUp(quest.getReward());
      } catch (InterruptedException | RuntimeException e) {
        log.error("Caught exception:", e);
      }
      return player;
    }, questExecutor);
  }

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(5);
    QuestSystem questSystem = new QuestSystem();

    Player player1 = new Player("Frodo", 10, 200);
    Player player2 = new Player("Saruman", 12, 300);

    Quest quest1 = new Quest("Find the ring", 10, 100);
    Quest quest2 = new Quest("Get the power", 12, 500);

    questSystem.startQuest(player1, quest1, executor).thenAccept(System.out::println);
    questSystem.startQuest(player2, quest2, executor).thenAccept(System.out::println);

    if (!executor.awaitTermination(MAX_WAITING_TIME, TimeUnit.SECONDS)) {
      executor.shutdownNow();
      if (!executor.awaitTermination(MAX_WAITING_TIME, TimeUnit.SECONDS)) {
        System.out.println("the pool did not terminate");
      }
    }
  }

}
