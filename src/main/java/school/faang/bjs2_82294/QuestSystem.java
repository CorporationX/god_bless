package school.faang.bjs2_82294;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest, ExecutorService executorService) {
        final int timeToCompliedQuest = getTime(quest);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(timeToCompliedQuest);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            player.addExperience(quest.reward());
            return player;
        }, executorService);
    }

    private int getTime(Quest quest) {
        return switch (quest.difficulty()) {
            case EASY -> 1;
            case MEDIUM -> 2;
            case HARD -> 3;
        };
    }
}
