package school.faang.BJS2_62054;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {

    private final ExecutorService executor = Executors.newFixedThreadPool(THREADS_AMOUNT);
    private static final long SLEEP_MULTIPLIER = 1000L;
    private static final int THREADS_AMOUNT = 2;
    private final Object lock = new Object();

    public CompletableFuture<Player> startQuest(@NonNull Player player, @NonNull Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(SLEEP_MULTIPLIER * quest.difficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Quest interrupted", e);
            }
            return player;
        }, executor)
                .thenApply(p -> {
                    synchronized (lock) {
                        int newExperience = p.getExperience() + quest.reward();
                        p.setExperience(newExperience);
                        return p;
                    }
                })
                .exceptionally(throwable -> {
                    log.warn("Quest failed for player {}: {}",
                            player.getName(), throwable.getCause().getMessage());
                    return player;
                });
    }

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Piter", 10, 250);
        Player player2 = new Player("Andrey", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        final CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        final CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        CompletableFuture<Void> allDone = CompletableFuture.allOf(player1Quest, player2Quest);
        allDone.join();

        questSystem.executor.shutdown();

        player1Quest.thenAccept(player -> System.out.printf(
                "%s has completed the quest and now has %d experience points.\n",
                        player.getName(), player.getExperience()));
        player2Quest.thenAccept(player -> System.out.printf(
                "%s has completed the quest and now has %d experience points.\n",
                        player.getName(), player.getExperience()));
    }
}
