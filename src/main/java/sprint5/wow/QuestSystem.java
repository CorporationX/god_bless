package sprint5.wow;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(getStartQuestSupplier(player, quest));
    }

    private static Supplier<Player> getStartQuestSupplier(Player player, Quest quest) {
        return () -> {
            System.out.printf("%s start quest %s\n", player.getName(), quest.name());
            try {
                Thread.sleep(quest.difficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.gainExperience(quest.reward());
            return player;
        };
    }
}
