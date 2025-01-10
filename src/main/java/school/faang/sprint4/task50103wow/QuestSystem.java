package school.faang.sprint4.task50103wow;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return player;
            }
            player.updateExperience(quest);
            return player;
        });
    }
}
