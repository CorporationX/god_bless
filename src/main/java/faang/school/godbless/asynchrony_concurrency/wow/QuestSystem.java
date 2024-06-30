package faang.school.godbless.asynchrony_concurrency.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        try {
            Thread.sleep(1_000);
            Player updPlayer = new Player(player.name(), player.level() + quest.difficulty(), player.experience() + quest.reward());

            return CompletableFuture.supplyAsync(() -> updPlayer);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}