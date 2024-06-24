package faang.school.godbless.multithreading.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        System.out.printf("%s takes the quest: %s", player.getName(), quest.name());
        try {
            Thread.sleep(quest.difficulty());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.completedFuture(player);
    }
}
