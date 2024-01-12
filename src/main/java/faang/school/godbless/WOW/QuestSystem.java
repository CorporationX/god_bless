package faang.school.godbless.WOW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        CompletableFuture<Player> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName() + " starts to do quest " + quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000L);
                int x = player.getExperience() + quest.getReward();
                System.out.println(player.getName() + " получает опыт - " + quest.getReward());
                player.setExperience(x);
                return player;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return future;
    }
}
