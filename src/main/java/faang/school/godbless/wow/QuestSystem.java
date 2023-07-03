import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> playerWithNewExperience = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * quest.getDifficulty());
                player.setExperience(player.getExperience() + quest.getReward());
                return player;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        playerWithNewExperience.join();

        return playerWithNewExperience;
    }
}
