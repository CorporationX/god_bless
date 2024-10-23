package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Thrall");
        Player player2 = new Player("Sylvanas");

        Quest quest1 = new Quest("Defeat the Lich King", Quest.Difficulty.HARD, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", Quest.Difficulty.MEDIUM, 100);

        try (QuestSystem questSystem = new QuestSystem()) {
            CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
            CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
            player1Quest.thenAccept(Main::logPlayerInfo);
            player2Quest.thenAccept(Main::logPlayerInfo);
        }
    }

    private static void logPlayerInfo(Player player) {
        log.info(
                "{} has completed the quest and now has {} experience points.",
                player.getName(), player.getExperience()
        );
    }
}
