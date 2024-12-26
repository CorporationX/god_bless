package school.faang.sprint_4.task_wowbjs2n49989;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class WowMain {
    private static int MAIN_THREAD_WORK_TIME = 2000;

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        List<Player> players = List.of(
                new Player("Thrall", 10, 250),
                new Player("Sylvanas", 12, 450)
        );

        List<Quest> quests = List.of(
                new Quest("Defeat the Lich King", 10, 150),
                new Quest("Retrieve the Sword of Azeroth", 8, 100)
        );

        List<CompletableFuture<Player>> playerQuestsFutures = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            playerQuestsFutures.add(questSystem.startQuest(players.get(i), quests.get(i)));
        }

        for (CompletableFuture<Player> playerCompletableFuture : playerQuestsFutures) {
            playerCompletableFuture.thenAccept(player ->
                    log.info("'{}' has completed the quest and now has {} experience points.",
                            player.getName(), player.getExperience()));
        }

        try {
            Thread.sleep(MAIN_THREAD_WORK_TIME);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
