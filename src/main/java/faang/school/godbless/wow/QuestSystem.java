package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        System.out.println("Квест " + quest.getName() + " для игрока " + player.getName() + " начался");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<Player> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            player.setExperience(player.getExperience() + quest.getReward());

            return player;
        }, executorService);

        executorService.shutdown();

        return completableFuture;
    }
}

