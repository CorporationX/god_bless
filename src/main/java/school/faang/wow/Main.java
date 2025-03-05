package school.faang.wow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        logQuestCompletion(player1Quest);
        logQuestCompletion(player2Quest);
    }

    public static void logQuestCompletion(CompletableFuture<Player> questFuture) {
        questFuture.thenAccept(player -> logger.info(
                "{} has completed the quest and now has {} experience points.",
                player.getName(),
                player.getExperience()
        ));
    }
}
