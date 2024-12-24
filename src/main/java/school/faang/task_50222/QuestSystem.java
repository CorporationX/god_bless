package school.faang.task_50222;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Старт");
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                System.out.println("Exception " + e);
            }
            player.addExperience(quest.getDifficulty());
            System.out.println("Стоп");

            return player;
        });

        return future;
    }
}
