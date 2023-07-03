package Sprint_4_1_Task3;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    @SneakyThrows
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        Thread.sleep(1000L * quest.getDifficulty());
        System.out.println("" + player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points.");
        player.setExperience(player.getExperience() + quest.getReward());
        return CompletableFuture.completedFuture(player);
    }
}
