package school.faang.java.thread2.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("\nЗапускать выполнение квеста асинхронно: Quest %s , Player %s", quest.toString(), player.toString());
            try {
                Thread.sleep(quest.difficulty());
            } catch (InterruptedException e) {
                throw new IllegalArgumentException("EQS001 - InterruptedException");
            }
            return new Player(player.name(), player.level(), player.experience() + quest.reward());
        });
    }
}