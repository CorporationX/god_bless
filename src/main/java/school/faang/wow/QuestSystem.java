package school.faang.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {

    private final ExecutorService executor;

    public QuestSystem(ExecutorService executor) {
        this.executor = executor;
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(player.getName() + " started the quest " + quest.getName());
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player.addExperience(quest.getReward());
            System.out.println(player.getName() + " completed the quest " + quest.getName());
            return player;
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}

