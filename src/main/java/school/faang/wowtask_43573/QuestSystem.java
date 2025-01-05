package school.faang.wowtask_43573;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> thisQuest = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            player.setLevel(quest.getDifficulty() / 10);
            System.out.printf("Квест %s завершен. Игрок %s набрал %d опыта \n", quest.getQuestName(), player.getName(),
                    player.getExperience());
            return player;
        });
        return thisQuest;
    }
}

