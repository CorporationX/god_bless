package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
  public CompletableFuture<Player> startQuest(Player player, Quest quest) {
    try {
      Thread.sleep(quest.getDifficulty());
      return CompletableFuture.supplyAsync(() -> player);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
