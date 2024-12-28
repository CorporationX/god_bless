package school.faang.moduleone.sprintfour.task_43573;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
public class QuestSystem {
    private final ExecutorService executor;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            quest.run();
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        }, executor);
    }
}
