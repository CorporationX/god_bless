package faang.school.godbless.multithreading_async.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(player.getName() + " начал выполнять квест " + quest.getName());
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        }, executorService);
    }

    public void shutdownExecutorService() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
