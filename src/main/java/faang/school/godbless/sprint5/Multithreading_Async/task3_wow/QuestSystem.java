package faang.school.godbless.sprint5.Multithreading_Async.task3_wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            player.setExperience(player.getExperience() + quest.getReward() * 100);
            return player;
        });
    }
}
