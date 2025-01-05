package school.faang.sprint_4.task_43573;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> firstPlayerQuest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> secondPlayerQuest = questSystem.startQuest(player2, quest2);

        CompletableFuture.allOf(firstPlayerQuest, secondPlayerQuest).join();

        firstPlayerQuest.thenAccept(player -> System.out.println(player.getName() + " получил "
                + player.getExperience() + " опыта."));
        secondPlayerQuest.thenAccept(player -> System.out.println(player.getName() + " получил "
                + player.getExperience() + " опыта."));
    }
}
