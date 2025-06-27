package school.faang.wow82282;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;


public class QuestSystem {


    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws InterruptedException {

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
                player.addExpirience(quest.getReward());
                System.out.printf("квест %s выполнен%n", quest.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return player;
        });

    }
}
