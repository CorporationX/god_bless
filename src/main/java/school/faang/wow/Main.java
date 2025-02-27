package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        try {
            player1Quest.get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error in thread1");
        }
        try {
            player2Quest.get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error in thread2");
        }

        player1Quest.thenAccept(player -> log.debug("{} has completed the quest1 and now has {} experience points.",
                player.getName(), player.getExperience()));
        player2Quest.thenAccept(player -> log.debug("{} has completed the quest2 and now has {} experience points.",
                player.getName(), player.getExperience()));

    }
}
