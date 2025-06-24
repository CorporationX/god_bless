package school.faang.bjs2_82252;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        Player player3 = new Player("Jeka", 99, 350);

        Quest quest1 = new Quest("Find the moon", 1, 500);
        Quest quest2 = new Quest("Find the Earn", 5, 1000);
        Quest quest3 = new Quest("Find the Mars", 10, 5000);

        CompletableFuture<Player> futureQuest1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> futureQuest2 = questSystem.startQuest(player2, quest2);
        CompletableFuture<Player> futureQuest3 = questSystem.startQuest(player3, quest3);

        futureQuest1.thenAccept(player ->
                log.info("{} has completed the quest and now has {} experience points.", player.getName(),
                        player.getExperience()));
        futureQuest2.thenAccept(player ->
                log.info("{} has completed the quest and now has {} experience points.", player.getName(),
                        player.getExperience()));
        futureQuest3.thenAccept(player ->
                log.info("{} has completed the quest and now has {} experience points.", player.getName(),
                        player.getExperience()));

        CompletableFuture.allOf(futureQuest1, futureQuest2, futureQuest3).join();
        log.info("All quests completed.");
    }
}
