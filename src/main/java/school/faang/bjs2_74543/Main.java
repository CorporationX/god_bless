package school.faang.bjs2_74543;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int TERMINATION_TIME = 30;

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        ExecutorService executor = Executors.newCachedThreadPool();

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1, executor);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2, executor);

        player1Quest.thenAccept(player ->
                System.out.println(player.getName()
                        + " has completed the quest and now has "
                        + player.getExperience()
                        + " experience points."));
        player2Quest.thenAccept(player ->
                System.out.println(player.getName()
                        + " has completed the quest and now has "
                        + player.getExperience()
                        + " experience points."));

        terminateExecutor(executor);
    }

    private static void terminateExecutor(ExecutorService executor) {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TERMINATION_TIME, TimeUnit.SECONDS)) {
                log.info("Задачи не завершились за {} минут, принудительно останавливаем...", TERMINATION_TIME);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
