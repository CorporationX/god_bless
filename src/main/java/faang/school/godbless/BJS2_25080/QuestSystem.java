package faang.school.godbless.BJS2_25080;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class QuestSystem {

    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
                    System.out.printf("%s starting quest %s%n", player.getName(), quest.getName());
                    addExperience(player, quest);
                    System.out.printf("%s ending quest %s%n", player.getName(), quest.getName());
                    return player;
                })
                .thenApply(result -> {
                    System.out.printf("%s has completed the quest! His current level: %d. And experience: %d%n",
                            result.getName(),
                            result.getLevel(),
                            result.getExperience()
                    );
                    return result;
                })
                .orTimeout(40, TimeUnit.SECONDS);
    }

    private static void addExperience(Player player, Quest quest) {
        try {
            player.addExperience(quest.getReward());
            Thread.sleep(quest.getExecutionTime());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
