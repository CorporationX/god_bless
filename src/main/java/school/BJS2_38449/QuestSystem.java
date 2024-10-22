package school.BJS2_38449;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                int timeOfEvent = quest.getDifficulty() * 1000;
                Thread.sleep(timeOfEvent);
                player.setExperience(player.getExperience() + quest.getReward());
                return player;
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        });
    }
}
