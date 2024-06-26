package faang.school.godbless.BJS213852;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {

    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(String.format("Поток %s: игрок %s Начал квест %s", Thread.currentThread().getName(), player, quest));
                Thread.sleep(quest.difficulty() * 1000);
                System.out.println(String.format("Поток %s: игрок %s закончил квест %s", Thread.currentThread().getName(), player, quest));
                player.setExperience(player.getExperience() + quest.reward());
                return player;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, EXECUTOR);
    }

    public void shutdown() {
        EXECUTOR.shutdown();
    }
}
