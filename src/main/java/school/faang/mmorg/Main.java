package school.faang.mmorg;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> future1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> future2 = questSystem.startQuest(player2, quest2);

        future1.thenAccept(player ->
                log.info("{} has completed the quest and has {} xp", player.getName(), player.getExperience())
        );
        future2.thenAccept(player ->
                log.info("{} has completed the quest and has {} xp", player.getName(), player.getExperience())
        );

        CompletableFuture.allOf(future1, future2).join();

        questSystem.shutdown();
    }
}

