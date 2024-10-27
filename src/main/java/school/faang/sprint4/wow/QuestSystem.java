package school.faang.sprint4.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty()* 1000L);
            } catch (InterruptedException e) {
                System.out.println("Invalid thread");
            }
            return new Player(player.getName(),player.getLevel(),player.getExperience()+quest.getReward());
        });
    }
}
