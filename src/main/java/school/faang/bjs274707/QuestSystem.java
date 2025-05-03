package school.faang.bjs274707;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final long MULTIPLIER = 1000L;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("%s start %s%n", player.getName(), quest.name());
            try {
                Thread.sleep(quest.difficulty() * MULTIPLIER);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            player.addExperience(quest);
            System.out.printf("%s finished %s%n", player.getName(), quest.name());
            return player;
        });
    }
}