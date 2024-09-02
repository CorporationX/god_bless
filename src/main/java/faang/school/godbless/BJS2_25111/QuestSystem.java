package faang.school.godbless.BJS2_25111;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    CompletableFuture<Player> startQuest(Player player, Quest quest) {
        try {
            Thread.sleep(quest.getDifficulty() * 1000L);
            return CompletableFuture.supplyAsync(() -> player);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
