package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest, Executor executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("%s: %s started %s\n", Thread.currentThread().getName(), player.getName(), quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                System.out.printf("%s: %s interrupted\n", Thread.currentThread().getName(), player.getName());
            }
            player.setExperience(player.getExperience() + quest.getReward());
            updateExperienceAndLevel(player);

            return player;
        }, executor);
    }

    private void updateExperienceAndLevel(Player player) {
        if (player.getExperience() >= 1000) {
            player.setExperience(player.getExperience() - 1000);
            player.setLevel(player.getLevel() + 1);
        }
    }
}
