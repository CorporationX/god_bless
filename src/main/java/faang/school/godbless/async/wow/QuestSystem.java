package faang.school.godbless.async.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private final Long DURATION_QUEST = 100L;

    public CompletableFuture startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info(String.format("%s begin quest:%s", player.getName(), quest.getName()));
                Thread.sleep(quest.getDifficulty() * DURATION_QUEST);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player.addExperience(quest.getReward());
        });
    }
}
