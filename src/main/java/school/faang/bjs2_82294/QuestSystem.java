package school.faang.bjs2_82294;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {
    private static final int TIME_TO_COMPLETE_EASY_QUEST = 1;
    private static final int TIME_TO_COMPLETE_MEDIUM_QUEST = 2;
    private static final int TIME_TO_COMPLETE_HARD_QUEST = 3;

    public synchronized CompletableFuture<Player> startQuest(
            Player player, Quest quest, ExecutorService executorService) {
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
            case EASY -> TIME_TO_COMPLETE_EASY_QUEST;
            case MEDIUM -> TIME_TO_COMPLETE_MEDIUM_QUEST;
            case HARD -> TIME_TO_COMPLETE_HARD_QUEST;
        };
    }
}
