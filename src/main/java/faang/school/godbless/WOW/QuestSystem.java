package faang.school.godbless.WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        // создается впечатление, что все происходит по очереди в одном потоке
        CompletableFuture<Player> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Iгрок " + player.getName() + " начал прохождение " + quest.getName() + " в потоке " + Thread.currentThread().getName());
            try {
                Thread.sleep(quest.getDifficult() * 500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            System.out.println("Iгрок " + player.getName() + " получил награду " + quest.getReward() + " за прохождение квеста " + quest.getName() + " в потоке " + Thread.currentThread().getName());
            return player;
        });
        try {
            future.get(30, TimeUnit.SECONDS);
            return future;
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
