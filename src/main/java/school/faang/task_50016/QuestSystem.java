package school.faang.task_50016;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> futurePlayer = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(String.format("Player %s started completing the quest %s. Experience before: %d."
                                + " Reward: %d", player.getName(), quest.getName(), player.getExperience(),
                        quest.getReward()));
                Thread.sleep(quest.getDifficulty() * 1000);
                player.addExperience(quest.getReward());
                player.addLevel();
                return player;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return player;
        });
        futurePlayer.thenAccept(pl -> System.out.println(String.format("Player %s has %d experiens, level %d",
                pl.getName(), pl.getExperience(), pl.getLevel())));
        return futurePlayer;
    }
}
