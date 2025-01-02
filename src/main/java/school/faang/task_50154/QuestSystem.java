package school.faang.task_50154;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> questCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty());
                player.newExperience(quest.getReward());
            } catch (InterruptedException e) {
                System.out.println("Ошибка " + e);
            }
            return player;
        });
        questCompletableFuture.join();
        return questCompletableFuture;
    }
}
