package faang.school.godbless.multi_asyn.task2wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

// Создание игроков
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

// Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", 2, 350);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 10, 200);

// Запуск заданий
        CompletableFuture<Player> player1Quest = null;
        CompletableFuture<Player> player2Quest = null;

        player1Quest = questSystem.startQuest(player1, quest1);
        player2Quest = questSystem.startQuest(player2, quest2);

// Обработка результатов заданий
        player1Quest.thenAccept(player -> {
            if (player.isNewLevel()) {
                System.out.println("Level UP!!!  New level " + player.getName() + ": " + player.getLevel());
                player.setNewLevel(false);
            }

            System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points.\n");
        }).join();

        player2Quest.thenAccept(player -> {
            if (player.isNewLevel()) {
                System.out.println("Level UP!!!  New level " + player.getName() + ": " + player.getLevel());
                player.setNewLevel(false);
            }

            System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points.\n");
        }).join();
    }
}
