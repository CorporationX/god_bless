package school.faang.task_49975;

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

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player ->
                log.info("{} has completed the 1quest and now has {} experience points and level {}",
                        player.getName(), player.getExperience(), player.getLevel())
        );

        player2Quest.thenAccept(player ->
                log.info("{} has completed the 2quest and now has {} experience points and level {}",
                        player.getName(), player.getExperience(), player.getLevel())
        );

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }
}
