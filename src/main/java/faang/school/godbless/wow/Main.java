package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        QuestSystem questSystem = new QuestSystem();

// Создание игроков
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

// Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", Difficult.HIGH, Reward.GOLD);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", Difficult.LOW, Reward.SILVER);

// Запуск заданий
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

// Обработка результатов заданий
        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

        questSystem.getExecutorService().shutdown();
    }
}