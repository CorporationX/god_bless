package school.faang.sprint_4.task_49981;

import lombok.NonNull;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final long QUEST_DIFFICULTY_TIME_CALCULATOR = 1000;

    public CompletableFuture<Player> startQuest(@NonNull Player player, @NonNull Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.difficulty() * QUEST_DIFFICULTY_TIME_CALCULATOR);
                player.addExperience(quest.reward());
            } catch (InterruptedException e) {
                System.out.println("Quest interrupted");
            }
            return player;
        });
    }
}
