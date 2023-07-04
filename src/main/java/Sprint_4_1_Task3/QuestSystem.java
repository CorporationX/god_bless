package Sprint_4_1_Task3;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    @SneakyThrows
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(()-> {
            try {
                Thread.sleep(1000L * quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + player.getName() + " has completed the quest and now has "
                    + player.getExperience() + " experience points.");
            player.setExperience(player.getExperience() + quest.getReward());
                    return player;
        });
    }
}
