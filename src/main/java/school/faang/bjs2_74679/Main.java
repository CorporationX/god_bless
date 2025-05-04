package school.faang.bjs2_74679;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Задача "WOW"
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService questThreadPool = Executors.newFixedThreadPool(4);
        QuestSystem questSystem = new QuestSystem(questThreadPool);

        // Создание игроков
        Player player1 = new Player("Thrall");
        Player player2 = new Player("Sylvanas");

        // Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        // Запуск заданий
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        // Обработка результатов заданий
        player1Quest.thenAccept(player -> System.out.printf("Игрок %s молодец!!! У него теперь %d опыта.%n",
                player.getName(), player.getExperience().get()));
        player2Quest.thenAccept(player -> System.out.printf("Игрок %s молодец!!! У него теперь %d опыта.%n",
                player.getName(), player.getExperience().get()));

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }
}
