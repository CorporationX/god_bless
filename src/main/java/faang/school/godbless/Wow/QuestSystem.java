package faang.school.godbless.Wow;
import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getDifficulty());
            return player;
        });
    }
}


