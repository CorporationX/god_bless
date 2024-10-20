package school.faang.wow.main_code;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    private final static int THREAD_COUNT = 4;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

        CompletableFuture<Player> playerFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.addExperience(quest.getRevard());

            return player;
        }, service);

        service.shutdown();

        try {
            if (!service.awaitTermination(2, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            service.shutdownNow();
        }

        return playerFuture;
    }
}
