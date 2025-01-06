package school.faang.bjs50087;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public static final long QUEST_TIME = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> doQuest(quest))
                .thenApply((reward) -> {
                    player.increaseExperience(reward);
                    log.info("{} completed {}, current experience: {}",
                            player.getName(), quest.name(), player.getExperience());
                    return player;
                });
    }

    public int doQuest(Quest quest) {
        try {
            Thread.sleep(quest.difficulty() * QUEST_TIME);
        } catch (InterruptedException e) {
            log.info("Failure doing test");
            return 0;
        }
        return quest.reward();
    }
}
