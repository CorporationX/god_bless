package school.faang.sprint_4.task_bjs250027;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public static final long QUEST_WAITING_MULTIPLE = 1000L;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.difficulty() * QUEST_WAITING_MULTIPLE);
            } catch (InterruptedException e) {
                log.warn("Thread {} was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
            player.addExperience(quest.reward());
            return player;
        });
    }
}
