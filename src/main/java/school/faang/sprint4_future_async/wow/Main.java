package school.faang.sprint4_future_async.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, new AtomicInteger(250));
        Player player2 = new Player("Sylvanas", 12, new AtomicInteger(450));

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Void> player1Quest = questSystem.startQuest(player1, quest1)
                .exceptionally(ex -> {
                    System.err.printf("Ошибка в квесте 1: %s", ex.getMessage());
                    return player1;
                })
                .thenAccept(player ->
                        System.out.printf("%s завершил квест. Опыт: %d%n",
                                player.getName(), player.getExperience().get()));

        CompletableFuture<Void> player2Quest = questSystem.startQuest(player2, quest2)
                .exceptionally(ex -> {
                    System.err.printf("Ошибка в квесте 2: %s", ex.getMessage());
                    return player2;
                }).thenAccept(player ->
                        System.out.printf("%s завершил квест. Опыт: %d%n",
                                player.getName(), player.getExperience().get()));

        CompletableFuture.allOf(player1Quest, player2Quest)
                .thenRun(() -> System.out.println("Все квесты завершены!\n"))
                .join();

        questSystem.executorShutdown();
    }
}