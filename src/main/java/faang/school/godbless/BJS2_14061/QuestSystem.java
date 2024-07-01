package faang.school.godbless.BJS2_14061;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            player.setExperience(player.getExperience() + 1);
            return player;
        });
    }
}
