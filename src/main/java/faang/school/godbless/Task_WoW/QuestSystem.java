package faang.school.godbless.Task_WoW;

import lombok.NoArgsConstructor;

import java.util.concurrent.CompletableFuture;

@NoArgsConstructor
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws InterruptedException {
        Thread.sleep(100L *quest.getDifficulty());
        return CompletableFuture.supplyAsync(() -> {
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }
}
