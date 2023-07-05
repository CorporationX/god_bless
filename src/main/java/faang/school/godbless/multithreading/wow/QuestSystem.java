package faang.school.godbless.multithreading.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(
                () -> {
                    System.out.println(player.getName() + " started the quest: " + quest.getName());
                    try {
                        Thread.sleep(quest.getDifficulty());
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                    player.setExperience(player.getExperience() + quest.getReward());
                    return player;
                }
        );
    }
}
