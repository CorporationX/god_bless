package faang.school.godbless.WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        CompletableFuture<Player> future = CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println(player.getName() + " starts to do quest " + quest.getName());
                        Thread.sleep(quest.getDifficulty() * 1000L);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return player;
                })
                .thenApply(player1 -> {// что-то я вообще не понимаю ничего. Вроде по условию надо этот метод использовать,
                    int x = player1.getExperience() + quest.getReward();//но по факту разницы нет вообще.
                    System.out.println(player.getName()+" получает опыт - "+quest.getReward());
                    player1.setExperience(x);
                    return player1;
                });

        try {
            future.get(30, TimeUnit.SECONDS);
            return future;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
