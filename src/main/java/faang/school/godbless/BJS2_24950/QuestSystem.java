package faang.school.godbless.BJS2_24950;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException("Sleep error");
            }
            int oldExp = player.getExp();
            int questExp = quest.getReward();
            player.setExp(oldExp + questExp);
            return player;
        });
    }
}
