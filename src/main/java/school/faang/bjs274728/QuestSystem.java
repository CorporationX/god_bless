package school.faang.bjs274728;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {

    private static final long ONE_SECOND = 1000L;
    private static final ExecutorService service = Executors.newFixedThreadPool(3);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(quest.getDifficulty() * ONE_SECOND);
                    } catch (InterruptedException e) {
                        throw new IllegalArgumentException(e);
                    }
                    player.addExperience((quest.getReward()));
                    return player;
                }, service);
    }
}
