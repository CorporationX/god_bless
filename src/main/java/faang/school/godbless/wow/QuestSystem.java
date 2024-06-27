package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player,Quest quest) {
        CompletableFuture<Player> res = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(quest.getDifficulty()*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return new Player(player.getName(), player.getLevel(), player.getExperience() + 1);
        });
        return res;
    }
}
