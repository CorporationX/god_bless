package faang.school.godbless.WOW;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

@AllArgsConstructor
@Slf4j
public class QuestSystem {
    private ExecutorService executorService;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} is starting quest {}", player.getName(), quest.name());
                SECONDS.sleep(quest.difficulty());
                player.addExperience(quest.reward());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return player;
        }, executorService);
    }
}
