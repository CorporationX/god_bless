package faang.school.godbless.BJS2_24999;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(player.getName() + " начал квет " + quest.getName());
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience((player.getExperience()) + quest.getReward());
            player.upLevel();
            return player;
        });
    }
}
