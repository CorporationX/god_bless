package school.faang.future_completable_future.bjs2_92579;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static school.utils.Utils.runWithThreadErrorHandling;
import static school.utils.Utils.shutdownAndAwaitTermination;

public class QuestSystem {
    private static final int NUMBER_OF_THREADS = 10;
    private static final ExecutorService EXECUTE = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static void stopQuestProcessingAndAwaitTermination() {
        shutdownAndAwaitTermination(EXECUTE);
    }

    public CompletableFuture<Player> startQuest(Player player, Quest guest) {
        return CompletableFuture.supplyAsync(() -> {
            playGuest(guest.difficulty());
            player.addExperience(guest.difficulty());
            return player;
        }, EXECUTE);
    }

    private void playGuest(Long timeDelay) {
        runWithThreadErrorHandling(() -> Thread.sleep(timeDelay));
    }
}