package school.faang.BJS2_38548_WOW;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final int MILLISECONDS_IN_SECOND = 1_000;

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(QuestSystem::logQuestComplete);
        player2Quest.thenAccept(QuestSystem::logQuestComplete);

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Player {} started the quest {}", player.getName(), quest.getName());
            try {
                Thread.sleep((long) quest.getDifficulty() * MILLISECONDS_IN_SECOND);
            } catch (InterruptedException e) {
                log.error(
                        "Thread {} was interrupted while player {} ws completing his quest {}",
                        Thread.currentThread().getName(), player.getName(), quest.getName(),
                        e
                );
            }
            player.updateExperience(quest.getReward());
            return player;
        });
    }

    private static void logQuestComplete(Player player) {
        log.info("Player {} has completed the quest and now has {} experience points.", player.getName(), player.getExperience());
    }
}
