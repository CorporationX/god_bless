package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        System.out.println(player.getName() + " has started the quest " + quest.getName());

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + (quest.getDifficulty() * 10));
            System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() +
                    " experience points.");
            return player;
        });
    }
}
