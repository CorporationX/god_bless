package faang.school.godbless.Wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        try {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(quest.getDifficulty() * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(player + " до квеста");
                player.setExperience(player.getExperience() + quest.getReward());
                System.out.println(player + " после квеста");
                return player;
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
