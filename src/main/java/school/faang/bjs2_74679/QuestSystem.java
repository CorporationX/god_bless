package school.faang.bjs2_74679;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
public class QuestSystem {
    public static final long DIFFICULTY_MULTIPLIER = 1000;

    private final ExecutorService threadPool;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("Игрок %s начал выполнение квеста %s%n", player.getName(), quest.name());
                Thread.sleep(quest.difficulty() * DIFFICULTY_MULTIPLIER);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.printf("Игрок %s завершил квест %s и получает %d опыта%n",
                    player.getName(), quest.name(), quest.reward());
            player.getExperience().addAndGet(quest.reward());
            return player;
        }, threadPool);
    }
}
