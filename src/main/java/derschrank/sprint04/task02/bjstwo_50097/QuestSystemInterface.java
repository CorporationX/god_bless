package derschrank.sprint04.task02.bjstwo_50097;

import java.util.concurrent.CompletableFuture;

public interface QuestSystemInterface {
    CompletableFuture<Player> startQuest(Player player, Quest quest);
}
