package school.faang.task_49983;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        CompletableFuture<Void> completableFuture1 = player1Quest.thenAccept(Main::logQuestResult);

        CompletableFuture<Void> completableFuture2 = player2Quest.thenAccept(Main::logQuestResult);

        completableFuture1.get();
        completableFuture2.get();
    }

    private static void logQuestResult(Player player) {
        log.info("Player: {} has completed the quest and now has {} experience points.",
                player.getName(), player.getExperience());
    }
}
