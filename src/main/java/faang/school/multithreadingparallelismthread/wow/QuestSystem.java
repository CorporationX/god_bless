package faang.school.multithreadingparallelismthread.wow;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;


public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                sleep(quest.getDifficulty() * 1000L);
                player.setExperience(player.getExperience() + quest.getReward());
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            return player;
        });
    }
}
