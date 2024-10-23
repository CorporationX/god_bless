package school.faang.sprint_4.bjs2_38638_wow;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private final ExecutorService executor;

    public QuestSystem() {
        executor = Executors.newCachedThreadPool();
    }

    public CompletableFuture<Player> startQuesting(Player player, List<Quest> quests) {

        List<CompletableFuture<Void>> completedQuests = quests.stream()
                .map(quest -> CompletableFuture.runAsync(() -> startQuest(player, quest), executor))
                .toList();

        return CompletableFuture.allOf(completedQuests.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Player {} finished all quests, has level {} and {} exp.",
                        player.getName(), player.getLevel(), player.getExp()))
                .thenApply(v -> player);
    }

    private void startQuest(Player player, Quest quest) {
        String playerName = player.getName();
        String questName = quest.getName();
        int difficulty = quest.getDifficulty();
        int expReward = quest.getExpReward();

        try {
            log.info("{} started quest {}. It takes {} seconds",
                    playerName, questName, difficulty);
            Thread.sleep(quest.getDifficulty() * 1000L);
            log.info("{} has completed the quest {} and got {} exp.",
                    playerName, questName, expReward);
            player.addExperience(expReward);
        } catch (InterruptedException e) {
            log.error("An error occurred while thread sleeping.", e);
            throw new IllegalStateException(e);
        }
    }

    public void shutDownExecutor() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                log.info("Something went wrong! Shutting down immediately!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while thread shutting down now.", e);
            throw new IllegalStateException(e);
        }
    }
}
