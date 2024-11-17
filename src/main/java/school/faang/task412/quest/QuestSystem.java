package school.faang.task412.quest;

import school.faang.task412.player.Player;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    private ExecutorService service = Executors.newFixedThreadPool(3);
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                player.addExperience(quest.getReward());
                Thread.sleep(1000L * quest.getDifficulty());
                return player;
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        },service);
    }
    public void shutdown(){
        service.shutdown();
        try {
            if(!service.awaitTermination(1, TimeUnit.MINUTES)){
                System.out.println("Ошибка");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
