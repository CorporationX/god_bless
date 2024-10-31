package school.faang.sprints.sprint4.wow;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
public class QuestSystem {

    public static final long ONE_SECOND_IN_MILLIS = 1000;

    private ExecutorService executorService;

    CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> playQuest(player, quest), executorService)
                .thenApply((_player) -> rewardPlayer(_player, quest));
    }

    private Player playQuest(Player player, Quest quest) {
        try {
            Thread.sleep(quest.getDifficulty() * ONE_SECOND_IN_MILLIS);
            return player;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Thread of quest was interrupted");
        }
    }

    private Player rewardPlayer(Player p, Quest quest) {
        p.addExperience(quest.getReward());
        return p;
    }
}
