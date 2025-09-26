package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    private static final long MILLIS_PER_DIFFICULTY_UNIT = 1000L;
    private final ExecutorService executor;

    public QuestSystem() {
        this.executor = Executors.newFixedThreadPool(5, r -> {
            Thread thread = new Thread(r);
            thread.setName("quest-worker-" + thread.getId());
            thread.setDaemon(true);
            return thread;
        });
    }

    public static void print(Player player) {
        log.info("{} has completed the quest and now has {} experience points.", player.name(), player.experience());
    }

    CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Player {} started quest: {}", player.name(), quest.name());
                Thread.sleep(quest.difficulty() * MILLIS_PER_DIFFICULTY_UNIT);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Quest was interrupted: " + quest.name(), e);
            }

            Player updatedPlayer = new Player(
                    player.name(),
                    player.level(),
                    player.addExperience(quest.reward())
            );

            log.info("Player {} completed quest: {}", player.name(), quest.name());
            return updatedPlayer;
        }, executor).exceptionally(throwable -> {
            log.error("Quest failed for player {}: {}", player.name(), throwable.getMessage());
            return player;
        });
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        try {
            Player player1 = new Player("Thrall", 10, 250);
            Player player2 = new Player("Sylvanas", 12, 450);

            Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
            Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

            CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
            CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

            player1Quest.thenAccept(QuestSystem::print);
            player2Quest.thenAccept(QuestSystem::print);

            CompletableFuture.allOf(player1Quest, player2Quest).join();

            log.info("All quests completed!");

        } finally {
            questSystem.shutdown();
        }
    }
}
