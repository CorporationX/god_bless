package school.faang.s_4_1_wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> questAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("Player " + player.getName() + " started quest");
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player;
        });
        return questAsync.thenApply(playerAfterBattle -> {
            System.out.println("Player " + playerAfterBattle.getName() + " ended quest");
            return playerAfterBattle.increaseExperience(quest.getReward());
        })
                .thenApply(playerInChain -> playerInChain.levelUp(quest.getDifficulty()));
    }
}
