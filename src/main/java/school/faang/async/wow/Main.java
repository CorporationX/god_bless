package school.faang.async.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, new AtomicInteger(250));
        Player player2 = new Player("Sylvanas", 12, new AtomicInteger(450));

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        showQuestCompletionMsg(player1Quest);
        showQuestCompletionMsg(player2Quest);

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }

    private static void showQuestCompletionMsg(CompletableFuture<Player> playerQuest) {
        playerQuest.thenAccept(player -> log.info("{} has completed the quest and now has {} experience points.",
                player.getName(), player.getExperience()));
    }
}
