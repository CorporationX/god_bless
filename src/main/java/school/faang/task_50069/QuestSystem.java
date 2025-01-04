package school.faang.task_50069;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final int QUEST_TIME = 3000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        if (player == null || quest == null) {
            throw new IllegalArgumentException("Quest or player is null");
        }
        System.out.println("THE PLAYER" + player + "HAS CHOSEN A QUEST" + quest);
        return CompletableFuture.supplyAsync(() -> {
            player.setExperience(player.getExperience() + quest.getDifficulty());
            player.setLevel(player.getLevel() + 1);
            try {
                Thread.sleep(QUEST_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player;
        });
    }
}
