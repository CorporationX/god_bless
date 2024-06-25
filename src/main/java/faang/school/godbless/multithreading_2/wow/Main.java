package faang.school.godbless.multithreading_2.wow;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 3, 250);
        Player player2 = new Player("Sylvanas", 4, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> futurePlayer1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> futurePlayer2 = questSystem.startQuest(player2, quest2);

        futurePlayer1.thenAccept(player -> System.out.println(player.getName() +
                " завершил квест с опытом " + player.getExperience()));
        futurePlayer2.thenAccept(player -> System.out.println(player.getName() +
                " завершил квест с опытом " + player.getExperience()));

        futurePlayer1.join();
        futurePlayer2.join();
    }
}
