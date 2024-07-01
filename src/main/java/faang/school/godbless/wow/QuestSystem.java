package faang.school.godbless.wow;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class QuestSystem {
    private final long INCREASING_TIME_PER_DIFFICULTY = 100L;

    public CompletableFuture<Player> startQuest(@NonNull Player player,
                                                @NonNull Quest quest,
                                                @NonNull ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> getPlayerOnPassQuest(player, quest), executorService);
    }

    private Player getPlayerOnPassQuest(Player player, Quest quest) {
        try {
            Thread.sleep(quest.getDifficulty() * INCREASING_TIME_PER_DIFFICULTY);
        } catch (InterruptedException e) {
            throw new RuntimeException("Player was injured during quest and had to stop the quest");
        }

        int earnedExperience = quest.getDifficulty() * quest.getReward();
        player.increaseExperienceBy(earnedExperience);

        return player;
    }
}
