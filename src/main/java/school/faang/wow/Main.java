package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Игрок 1", 10, 250);
        Player player2 = new Player("Игрок 2", 12, 450);

        Quest quest1 = new Quest("Победить Короля Артура", 10, 150);
        Quest quest2 = new Quest("Вернуть меч Азерота", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> System.out.println(player
                .getName() + " выполнил квест и теперь имеет " + player
                .getExperience() + " очков опыта."));
        player2Quest.thenAccept(player -> System.out.println(player
                .getName() + " выполнил квест и теперь имеет " + player
                .getExperience() + " очков опыта."));

        CompletableFuture.allOf(player1Quest, player2Quest).join();
        System.out.println("Все квесты завершены.");
    }
}
