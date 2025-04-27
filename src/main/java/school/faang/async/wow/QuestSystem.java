package school.faang.async.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        log.info("{} starting quest: {}", player.getName(), quest.name());
        return CompletableFuture.supplyAsync(() -> {
            player.addExperience(quest.reward());
            return player;
        }, CompletableFuture.delayedExecutor(quest.difficulty(), TimeUnit.SECONDS));
    }
}
