package faang.school.godbless.WOW;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> playerFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.addExperience(quest.getReward());
            return player;
        });
        return playerFuture;
    }
}
