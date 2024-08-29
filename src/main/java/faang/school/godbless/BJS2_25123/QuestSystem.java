package faang.school.godbless.BJS2_25123;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player;
        }).thenApply(player1 -> new Player(player.getName(), player.getLevel(), player.getExperience() + quest.getReward()));
    }
}
