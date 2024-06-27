package faang.school.godbless.domain.task_WOW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        try {
            Thread.sleep(quest.difficulty() * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.supplyAsync(() ->
                new Player(player.name(), player.level(), getNewExperience(player, quest)));
    }

    private static int getNewExperience(Player player, Quest quest) {
        return player.experience() + quest.reward();
    }
}

