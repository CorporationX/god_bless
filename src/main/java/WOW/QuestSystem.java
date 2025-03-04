package WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QuestSystem {
    private static final long TIME_MULTIPLIER = 100L;
    private static ExecutorService executor;

    public QuestSystem() {
        executor = Executors.newCachedThreadPool();
    }

    public static CompletableFuture<Player> startQuest (Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() ->  {
            try {
                System.out.printf("Игрок: %s начал выполнение квеста: %s%n", player.getName(), quest.getName());
                Thread.sleep(quest.getDifficulty() * TIME_MULTIPLIER);
                if (player.getLevel() >= quest.getDifficulty()) {
                    player.addExperience(quest.getReward());
                    System.out.printf("Игрок: %s выполнил задание %s%n", player.getName(), quest.getName());
                } else {
                    System.out.printf("Игрок %s не может выполнить задание '%s'. Недостаточный уровень.%n",
                            player.getName(), quest.getName());
                }
            } catch (InterruptedException e) {
                System.out.printf("Выполнение задания '%s' было прервано.%n", quest.getName());
                Thread.currentThread().interrupt();
            }
            return player;
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Принудительное завершение всех задач");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Ожидание завершения было прервано: " + e.getMessage());
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
