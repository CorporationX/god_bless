package school.faangSprint4.t04;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    private final ExecutorService executorService;

    public QuestSystem(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName() + " started quest: " + quest.name());
                TimeUnit.SECONDS.sleep(quest.difficulty());
                player.addExperience(quest.reward());
                return player;
            } catch (InterruptedException e) {
                throw new IllegalStateException("Quest execution was interrupted", e);
            }
        }, executorService);
    }
}