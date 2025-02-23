package school.faang.wow.program;

import school.faang.wow.model.Player;
import school.faang.wow.model.Quest;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(quest)
                .thenApplyAsync(experience -> {
                    player.addExperience(experience);
                    return player;
                });
    }
}
