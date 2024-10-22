package school.faang.godbless.bjs2_38510;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Game {
    public static void main(String[] args) {
        QuestSystem questSystem = QuestSystem.getInstance();
        Player player1 = new Player("Player1", 2, 200);
        Quest quest1 = new Quest("Quest1", 3000, 200);
        Quest quest2 = new Quest("Quest2", 3000, 400);
        CompletableFuture<Player> questFuture1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> questFuture4 = questSystem.startQuest(player1, quest2);
        questFuture1.thenAccept(Game::logExpAfterQuest);
        questFuture4.thenAccept(Game::logExpAfterQuest);
    }

    private static void logExpAfterQuest(Player player) {
        log.info("Player {} completed a quest and now has {} exp",
                player.getName(), player.getExperience());
    }
}
