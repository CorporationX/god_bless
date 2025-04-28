package school.faang.bjs2_74543;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest, ExecutorService executor) {
        return CompletableFuture.supplyAsync(quest::doQuest, executor)
                .thenApply(reward -> new Player(
                        player.getName(),
                        player.getLevel(),
                        player.getExperience() + reward
                ));
    }
}
