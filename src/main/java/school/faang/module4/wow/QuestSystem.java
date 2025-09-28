package school.faang.module4.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        log.info("Player {} starts quest {}", player.name(), quest.name());
                        Thread.sleep(quest.difficulty() * 1000L);
                        log.info("Player {} finished quest {}", player.name(), quest.name());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    return new Player(player.name(), player.level(), player.experience() + quest.difficulty());
                }
        );
    }
}
