package faang.school.godbless.asyncAndFuture.WOW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Quest is starting... Player: " + player.getName());
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player;
        });
    }
}
