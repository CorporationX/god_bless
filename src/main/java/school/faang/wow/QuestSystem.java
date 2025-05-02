package school.faang.wow;

import javax.print.DocFlavor;
import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.addXp(quest.getReward());
            return player;
        }).thenApply(updatedPlayer -> {
            System.out.println("Player: " + player.getName()
                    + "earned " + player.getXp() + "XP" + " for quest " + quest.getName());
            return updatedPlayer;
        });
    }
}

