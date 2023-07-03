package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest){
        CompletableFuture<Player> futurePlayer = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
        return futurePlayer;
    }
}
