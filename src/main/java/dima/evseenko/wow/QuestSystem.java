package dima.evseenko.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest, Executor executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                player.setExperience(player.getExperience() + quest.getReward());
                Thread.sleep(getQuestCompleteTime(quest));
                return player;
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new IllegalStateException("Ошибка при выполнении квеста %s игроком %s!".formatted(quest.getName(), player.getName()), e);
            }
        }, executor);
    }

    private int getQuestCompleteTime(Quest quest) {
        return switch (quest.getDifficulty()) {
            case EASY -> 1000;
            case MEDIUM -> 2000;
            case HARD -> 3000;
        };
    }
}
