package school.faang.m1s4.bjs2_38488_wow;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class QuestSystem {
    private final ExecutorService service = Executors.newFixedThreadPool(3);

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture
                .supplyAsync(() -> {
                    System.out.printf("%s starts the quest %s%n", player.getName(), quest.getName());
                    try {
                        Thread.sleep(quest.getDifficulty() * 1000L);
                    } catch (InterruptedException e) {
                        log.error("Thread has been terminated", e);
                    }
                    player.setExperience(player.getExperience() + quest.getReward());

                    return player;
                }, service);
    }

    public void shutdownService() {
        service.shutdown();
        try {
            if (!service.awaitTermination(30, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread has been terminated", e);
        }
    }

}
