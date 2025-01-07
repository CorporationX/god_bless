package school.faang.moduleone.sprintfour.task_43573;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREADS_NUMBER = 2;
    private static final int TIMEOUT = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_NUMBER);
        QuestSystem questSystem = new QuestSystem(executor);

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        CompletableFuture.allOf(
                player1Quest.thenAccept(player -> System.out.println(player.getName()
                        + " has completed the quest and now has " + player.getExperience() + " experience points.")),
                player2Quest.thenAccept(player -> System.out.println(player.getName()
                        + " has completed the quest and now has " + player.getExperience() + " experience points."))
        ).join();

        shutdownGracefully(executor);
    }

    private static void shutdownGracefully(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.error("часть потоков не завершили задачи в отведенное время. Останавливаем принудительно");
                executor.shutdownNow();
            }
            log.info("Все потоки завершились успешно");
        } catch (InterruptedException e) {
            log.error("Корректное завершение потоков было прервано. Останавливаем принудительно");
            executor.shutdownNow();
        }
    }
}
