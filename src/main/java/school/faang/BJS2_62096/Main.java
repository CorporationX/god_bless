package school.faang.BJS2_62096;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        QuestSystem questSystem = new QuestSystem();

        // Создание игроков
        Player player1 = new Player("Горец", 10, new AtomicInteger(4000));
        Player player2 = new Player("Рэмбо", 12, new AtomicInteger(5500));

        // Создание заданий
        Quest quest1 = new Quest("Победите короля-лича", 10, 150);
        Quest quest2 = new Quest("Верни Меч Азерота", 8, 100);

        // Запуск заданий
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        // Обработка результатов заданий
        player1Quest.thenAccept(player -> System.out.println(player.getName() + " выполнил задание и теперь имеет "
                + player.getExperience() + " очков опыта."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " выполнил задание и теперь имеет "
                + player.getExperience() + " очков опыта."));

        player1Quest.get(); // Блокируем основной поток, пока квест не завершится
        player2Quest.join(); // Блокируем основной поток, пока квест не завершится

        System.out.println("Все задания выполнены!");
    }
}