package wow;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Arthas", 5, 500);
        Player player2 = new Player("Karl", 10, 800);

        Quest quest1 = new Quest("To save the kingdom of Arendelle", 5, 100);
        Quest quest2 = new Quest("To become Invoker", 2, 200);

        CompletableFuture<Player> future1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> future2 = questSystem.startQuest(player2, quest2);

        future1.thenAccept(player ->
                        System.out.printf("%s has completed the quest. New experience %d",
                                player.getName(),
                                player.getExperience()))
                .join();

        future2.thenAccept(player ->
                        System.out.printf("%s has completed the quest. New experience %d",
                                player.getName(),
                                player.getExperience()))
                .join();
    }
}
