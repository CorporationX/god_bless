package school.faang.bjs2_82225_wow;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import school.faang.utils.ThreadUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Slf4j
public class QuestSystem {
    private static final int SHUTDOWN_DELAY_MINUTES = 10;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    @AllArgsConstructor
    private static class QuestRunner implements Supplier<Player> {
        @NonNull
        private final Player player;
        @NonNull
        private final Quest quest;

        @Override
        public Player get() {
            try {
                log.info("Executing quest {} for player {}", quest.getName(), player.getName());
                TimeUnit.SECONDS.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                log.error("Quest execution interrupted: {}", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            player.addExperience(quest.getReward());
            return player;
        }
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(new QuestRunner(player, quest), executorService);
    }

    public void shutDown() {
        ThreadUtils.executorGracefulShutdown(executorService, SHUTDOWN_DELAY_MINUTES, null);
    }
}