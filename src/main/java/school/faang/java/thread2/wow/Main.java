package school.faang.java.thread2.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        QuestSystem questSystem = new QuestSystem();

        System.out.printf("\n Start %s!", "1");
        CompletableFuture<Player> q1 = questSystem
                .startQuest(new Player("player1", 1, 2), new Quest("Quest1", 1000, 1))
                .thenApply(player -> {
                            System.out.printf("\n Start 1! -> Player updated: %s", player);
                            return player;
                        });

        System.out.printf("\n Start %s!", "2");
        CompletableFuture<Player> q2 = questSystem
                .startQuest(new Player("player2", 2, 3), new Quest("Quest2", 4000, 5))
                .thenApply(player -> {
                    System.out.printf("\n Start 2! -> Player updated: %s", player.toString());
                    return player;
                });

        System.out.printf("\n Start %s!", "3");
        CompletableFuture<Player> q3 = questSystem
                .startQuest(new Player("player3", 3, 4), new Quest("Quest3", 5000, 6))
                .thenApply(player -> {
                    System.out.printf("\n Start 3! -> Player updated: %s", player.toString());
                    return player;
                });
        q1.get();
        q2.get();
        q3.get();

        System.out.println("\n END!!!");

    }
}