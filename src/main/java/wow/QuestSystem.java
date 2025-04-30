package wow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@RequiredArgsConstructor
public class QuestSystem {
    private final ExecutorService executor;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> doQuest(player, quest), executor);
    }

    private synchronized Player doQuest(Player player, Quest quest) {
        log.info("Player {} start quest {}...", player.getName(), quest.getName());
        try {
            Thread.sleep(quest.getDifficulty());
            return addExperience(player, quest.getReward());
        } catch (InterruptedException e) {
            log.error("Player thread is interrupted! {}", e.getCause().getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
    }

    private Player addExperience(Player player, int reward) {
        player.setExperience(player.getExperience() + reward);
        return player;
    }
}
