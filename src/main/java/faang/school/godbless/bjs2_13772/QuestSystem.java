package faang.school.godbless.bjs2_13772;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {

  private static final long DEFAULT_EXECUTION_QUEST_TIME = 1_000L;
  private static final String EXECUTION_QUEST_INTERRUPTED_EXCEPTION = "Выполнение квеста было прервано. ";
  private static final String PLAYER_BEGIN_EXECUTION_QUEST = "Игрок \"%s\" начинает выполнять квест \"%s\".";

  ExecutorService executorService;

  public QuestSystem(ExecutorService executorService) {
    this.executorService = executorService;
  }

  public CompletableFuture<Player> startQuest(Player player, Quest quest) {
    return CompletableFuture.supplyAsync(() -> quest(player, quest), executorService);
  }

  private Player quest(Player player, Quest quest) {
    System.out.println(String.format(PLAYER_BEGIN_EXECUTION_QUEST, player.getName(), quest.name()));
    try {
      Thread.sleep(DEFAULT_EXECUTION_QUEST_TIME * quest.difficulty());
    } catch (InterruptedException e) {
      throw new RuntimeException(EXECUTION_QUEST_INTERRUPTED_EXCEPTION + e);
    }
    return player.getPlayerWithChangedExperience(quest.reward());
  }

}
