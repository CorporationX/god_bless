package school.faang.stream4.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            player.addExperience(quest.getReward());
            return player;
        });
    }
}
