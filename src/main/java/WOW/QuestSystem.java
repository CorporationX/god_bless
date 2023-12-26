package WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws ExecutionException, InterruptedException, TimeoutException {
//Обновляем опыт у игрока
        CompletableFuture<Player> updatedPlayer = CompletableFuture.supplyAsync(() -> {
            player.upExperience(quest.getReward());
            return player;
        });

        //"Выполняем" квест
        Thread sleep = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        sleep.start();
        updatedPlayer.get(5, TimeUnit.SECONDS);
        return updatedPlayer;
    }
}
