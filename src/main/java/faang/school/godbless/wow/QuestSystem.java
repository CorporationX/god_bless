package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1_000L);
                int experience = player.getExperience() + quest.getReward();
                player.setExperience(experience);

                return player;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
