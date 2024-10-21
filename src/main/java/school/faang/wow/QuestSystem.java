package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(player.getBedtime());
            } catch (InterruptedException e) {
                throw new IllegalStateException("во время ожидания возникли проблемы", e);
            }
            player.setExperience(player.getExperience() + quest.getPoints());
            return player;
        });
    }
}
