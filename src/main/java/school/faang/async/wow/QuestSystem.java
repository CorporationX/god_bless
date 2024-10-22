package school.faang.async.wow;

import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuestSystem {

  public CompletableFuture<Player> startQuest(Player player, Quest quest) {
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
    });
  }

  public static void main(String[] args) {
    QuestSystem questSystem = new QuestSystem();

    Player player1 = new Player("Frodo", 10, 200);
    Player player2 = new Player("Saruman", 12, 300);

    Quest quest1 = new Quest("Find the ring", 10, 100);
    Quest quest2 = new Quest("Get the power", 12, 500);

    questSystem.startQuest(player1, quest1).thenAccept(System.out::println).join();
    questSystem.startQuest(player2, quest2).thenAccept(System.out::println).join();
  }

}
