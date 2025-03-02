package school.faang.task_62196;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player thrall = new Player("Thrall", 10, 250);
        Player sylvanas = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 5, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(thrall, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(sylvanas, quest2);

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }
}
