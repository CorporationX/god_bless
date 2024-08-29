package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Start quest " + quest.getName() + " for player " + player.getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            System.out.println(player.getName() + " gained experience " + quest.getReward());
            return player;
        }).thenApply(out -> {
            System.out.println("Current experience " + player.getName() + " " + player.getExperience());
            return out;
        }).orTimeout(15, TimeUnit.SECONDS).exceptionally(ex -> {
            System.err.println("An error occurred: " + ex.getMessage());
            return player;
        });
    }
}
