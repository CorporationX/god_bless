package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class QuestSystemRunner {
    public static void main(String[] args) {
        Player player1 = new Player("Alice", 1, new AtomicInteger(0));
        Player player2 = new Player("Bob", 2, new AtomicInteger(100));

        Quest quest1 = new Quest("Defeat Monsters", 5, 50);
        Quest quest2 = new Quest("Find Treasure", 3, 30);

        QuestSystem questSystem = new QuestSystem();

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(QuestSystemRunner::playerInfo);
        player2Quest.thenAccept(QuestSystemRunner::playerInfo);

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }

    private static void playerInfo(Player player) {
        log.info("Player: {} experience: {}", player.getName(), player.getExperience());
    }
}
