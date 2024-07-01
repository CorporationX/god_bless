package faang.school.godbless.multithreading.async.wow;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int nThreads = 5;
        QuestSystem questSystem = new QuestSystem();
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

// Создание игроков
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

// Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", 6, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 3, 100);

// Запуск заданий
        List<CompletableFuture<Player>> quests = List.of(
                questSystem.startQuest(player1, quest1, executor),
                questSystem.startQuest(player2, quest2, executor));

// Обработка результатов заданий
        for (CompletableFuture<Player> quest : quests) {
            executor.execute(() -> quest
                    .thenAccept(player -> System.out.println(
                            player.getName() + " has completed the quest and now has "
                            + player.getExperience() + " experience points."))
                    .join());
        }

        executor.shutdown();
    }
}
