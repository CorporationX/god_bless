package school.faang.multithreading.async.bjs2_92551;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final long ONE_SECOND_DELAY = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("{} начинает выполнять квест {} ", player.getName(), quest.name());
            try {
                Thread.sleep(ONE_SECOND_DELAY * quest.difficulty());
                log.info("Квест '{}' выполнен", quest.name());
                player.updateExperience(quest.reward());
            } catch (InterruptedException e) {
                log.info("Выполнение квеста '{}' прервано", quest.name());
                throw new RuntimeException("Выполнение квеста '" + quest.name() + "' прервано", e);
            }
            return player;
        });
    }
}
