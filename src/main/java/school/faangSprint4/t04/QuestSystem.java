package school.faangSprint4.t04;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName() + " started quest: " + quest.name());
                TimeUnit.SECONDS.sleep(quest.difficulty());

                player.addExperience(quest.reward());

                return player;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Quest was interrupted", e);
            }
        });
    }
}