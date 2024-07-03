package faang.school.godbless.multithreading.async.wow;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        int nThreads = 5;
        QuestSystem questSystem = new QuestSystem();
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        Consumer<Player> playerConsumer = player ->
                System.out.println(player.getName()
                + " has completed the quest and now has "
                + player.getExperience() + " experience points.");

// Создание игроков
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

// Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", 6, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 3, 100);

// Запуск заданий
        List<CompletableFuture<Player>> quests = List.of(
                questSystem.startQuest(player1, quest1),
                questSystem.startQuest(player2, quest2));

// Обработка результатов заданий
            quests.forEach(quest -> executor.execute(() -> quest.thenAccept(playerConsumer).join()));

        executor.shutdown();
    }
}
