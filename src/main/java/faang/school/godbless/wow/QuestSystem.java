package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    CompletableFuture completableFuture = new CompletableFuture<String>();
    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws InterruptedException {
        return completableFuture.supplyAsync(() ->  startAttach(player, quest), executorService);//не понимаю
    }

    private CompletableFuture<Player> startAttach(Player player, Quest quest) throws InterruptedException {
        switch (quest.getDifficulty()) {
            case HIGH:
                Thread.sleep(10_000);
                player.setExperience(player.getExperience() + 10);
            case LOW:
                Thread.sleep(5_000);
                player.setExperience(player.getExperience() + 5);
            case MIN:
                Thread.sleep(1_000);
                player.setExperience(player.getExperience() + 1);
        }
        return new CompletableFuture<Player>(player); //не понимаю
    }
}
