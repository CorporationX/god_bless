package faang.school.godbless.wow;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    private static final Random random = new Random();
    @Getter
    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(random.nextInt(quest.difficulty() * 10));
            } catch (InterruptedException e) {
                throw new IllegalArgumentException(
                        "exception during asynchronous exception handling in the startQuest method of the questSystem class", e);
            }
            return quest.reward();
        }, executor).thenApply(result -> {
            player.setExperience(player.getExperience() + result);
            return player;
        });
    }
}
