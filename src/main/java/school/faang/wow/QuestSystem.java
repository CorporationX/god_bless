package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            long timeInProgress = (long) 1000 * quest.getDifficulty();
            int questReward = quest.getReward() + player.getExperience();

            try {
                Thread.sleep(timeInProgress);
                player.setExperience(questReward);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return player;
        });
    }
}
