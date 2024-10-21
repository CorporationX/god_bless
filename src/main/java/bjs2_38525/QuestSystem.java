package bjs2_38525;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest, ExecutorService service) {
        return CompletableFuture.supplyAsync(() -> {
            int experience = player.getExperience();
            System.out.println(player.getName() +
                    " with experience: " + experience +
                    " starts quest: " + quest.getName());

            try {
                TimeUnit.SECONDS.sleep(quest.getDifficulty());
                player.setExperience(experience + quest.getReward());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return player;
        }, service);
    }
}
