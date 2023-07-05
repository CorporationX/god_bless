package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
  public CompletableFuture<Player> startQuest(Player player, Quest quest) {
    return CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(500);
        return player;
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
  }
}
