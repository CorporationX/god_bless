package school.faang.Sprints.Multithreading_Async.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " +
                    player.getName() + " has completed the quest: + "
                    + quest.getReward() + " exp");
            player.updateExperience(quest);
            return player;
        });
    }
}
