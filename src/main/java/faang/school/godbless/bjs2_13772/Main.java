package faang.school.godbless.bjs2_13772;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

  private static final int POOL_SIZE = 5;
  private static final long TIME_OUT = 30;
  private static final String TERMINATED_INTERRUPTED_EXCEPTION = "Завершение executorService было прервано. ";

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

    QuestSystem questSystem = new QuestSystem(executorService);

    Player player1 = new Player("Thrall", 10, 250);
    Player player2 = new Player("Sylvanas", 12, 450);

    Quest quest1 = new Quest("Defeat the Lich King", 20, 150);
    Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

    var player1Quest = questSystem.startQuest(player1, quest1);
    var player2Quest = questSystem.startQuest(player2, quest2);

    player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
    player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

    shutdown(executorService);
  }

  private static void shutdown(ExecutorService executorService) {
    executorService.shutdown();
    try {
      executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(TERMINATED_INTERRUPTED_EXCEPTION + e);
    }
  }

}
