package wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

// Создание игроков
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        Player player3 = new Player("Illidan", 1, 0);

// Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);
        Quest quest3 = new Quest("Kill a boar", 1, 10);

// Запуск заданий
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
        CompletableFuture<Player> player3Quest = questSystem.startQuest(player3, quest3);

// Обработка результатов заданий
        player1Quest.thenAccept(Main::printCompletedQuestInfo);
        player2Quest.thenAccept(Main::printCompletedQuestInfo);
        player3Quest.thenAccept(Main::printCompletedQuestInfo);
    }

    private static void printCompletedQuestInfo(Player player) {
        System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points.");
    }
}
