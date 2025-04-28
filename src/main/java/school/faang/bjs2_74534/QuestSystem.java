package school.faang.bjs2_74534;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    public static final String PLAYER_IS_EMPTY = "player is empty";
    public static final String QUEST_IS_EMPTY = "quest is empty";
    private static final long MILLIS = 1000;
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        validateInputData(player, quest);
        log.info("start quest to \"{}\" (experience is {}) on \"{}\" (reward is {})",
            player.getName(), player.getExperience(), quest.name(), quest.reward());
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("player \"{}\" solving quest \"{}\" \"{}\" sec",
                    player.getName(), quest.name(), quest.difficulty());
                Thread.sleep(quest.difficulty() * MILLIS);
            } catch (InterruptedException e) {
                log.error("start quest interrupted: {}", e.getMessage(), e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return player.addExperience(quest.reward());
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private void validateInputData(Player player, Quest quest) {
        StringBuilder error = new StringBuilder();
        if (player == null) {
            appendError(error, PLAYER_IS_EMPTY);
        }
        if (quest == null) {
            appendError(error, QUEST_IS_EMPTY);
        }
        if (!error.isEmpty()) {
            Thread.currentThread().interrupt();
            throw new IllegalArgumentException(error.toString());
        }
    }

    private void appendError(StringBuilder error, String errorMessage) {
        if (!error.isEmpty()) {
            error.append(" ");
        }
        error.append(errorMessage);
    }
}
