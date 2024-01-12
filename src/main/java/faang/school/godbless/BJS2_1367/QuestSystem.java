package faang.school.godbless.BJS2_1367;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> result = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName()+" starts the "+quest.getName());
                Thread.sleep(quest.getDifficulty()*1000);
                System.out.println(player.getName()+" has completed the "+quest.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return player;
        });
        result.thenAccept(player1 -> {
            player1.setExperience(player1.getExperience() + (quest.getReward() / 100));
        });
        return result;
    }
}
