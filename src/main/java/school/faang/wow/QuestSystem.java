package school.faang.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private static final long TIME_WAIT = 100L;
    private static final int COUNT_THREAD = 2;
    private final ExecutorService service = Executors.newFixedThreadPool(COUNT_THREAD);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty().getComplexity() * TIME_WAIT);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            synchronized (player) {
                player.addExperience(quest.getReward().getPrize());
            }
            return player;
        }, service);
    }
}
