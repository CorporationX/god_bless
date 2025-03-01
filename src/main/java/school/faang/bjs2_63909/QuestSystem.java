package school.faang.bjs2_63909;

import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@NoArgsConstructor
public class QuestSystem {

    private static final int ONE_SECOND_IN_MS = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        validate(player, quest);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) quest.getDifficulty() * ONE_SECOND_IN_MS);
                System.out.printf("Квест: %s - завершен!\n", quest.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            player.upgradeExperience(quest.getReward());
            return player;
        });
    }

    private void validate(Player player, Quest quest) {
        Objects.requireNonNull(player, "Игрок не должен быть null");
        Objects.requireNonNull(quest, "Квест не должен быть null");
    }
}
