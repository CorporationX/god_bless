package faang.school.godbless.sprint5.wow.classes;

import faang.school.godbless.sprint5.wow.enums.Difficult;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            int curExp = player.getExperience();

            try {
                Thread.sleep(getDurationQuest(quest.getDifficult()) * 1_000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            player.setExperience(curExp + quest.getReward());
            return player;
        });
    }

    private long getDurationQuest(Difficult difficult) {
        return switch (difficult) {
            case EASY -> 3;
            case MEDIUM -> 5;
            case HARD -> 8;
            case LEGENDARY -> 10;
        };
    }
}