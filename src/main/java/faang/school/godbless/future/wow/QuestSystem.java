package faang.school.godbless.future.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println(player.getName() + " has completed the quest");
            return player;
        }).thenApply(finishedPlayer -> {
            finishedPlayer.setLevel(finishedPlayer.getLevel() + 1);
            System.out.println(finishedPlayer.getName() + " level is now " + finishedPlayer.getLevel());

            finishedPlayer.setExperience(finishedPlayer.getExperience() + quest.getReward());
            System.out.println(finishedPlayer.getName() + " experience is now " + finishedPlayer.getExperience());

            return finishedPlayer;
        });
    }
}