package school.faang.task_49955;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final int QUEST_TIMING = 5000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        if (player == null || quest == null) {
            throw new IllegalArgumentException("Player or quest is null");
        }
        System.out.println("Quest : " + quest + " was started by : " + player);
        return CompletableFuture.supplyAsync(() -> {
            try {
                player.setExperience(player.getExperience() + quest.getDifficulty());
                player.setLevel(player.getLevel() + 1);
                Thread.sleep(QUEST_TIMING);
            } catch (InterruptedException e) {
                System.out.println("Some error was occurred");
            }
            return player;
        });
    }
}
