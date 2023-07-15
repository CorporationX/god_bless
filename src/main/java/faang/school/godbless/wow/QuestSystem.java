package faang.school.godbless.wow;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> playerOnQuest = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            if(player.getLevel() > quest.getDifficulty()) {
                try {
                    Thread.sleep((random.nextInt(5)+1)*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                player.setExperience(player.getExperience() + quest.getReward());
            } else {
                throw new RuntimeException(player.getName() + " not ready yet for this quest!");
            }
            return player;
        });
        return playerOnQuest;
    }
}
