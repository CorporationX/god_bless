package school.faang;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        // Создание игроков
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        // Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        // Запуск заданий
        CompletableFuture<Player> player1Quest = QuestSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = QuestSystem.startQuest(player2, quest2);
        player1Quest.join();
        player2Quest.join();

        // Обработка результатов заданий
        player1Quest.thenAccept(player ->
                System.out.println(player.getName() + " has completed the quest and now has "
                        + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player ->
                System.out.println(player.getName() + " has completed the quest and now has "
                        + player.getExperience() + " experience points."));
    }
}
