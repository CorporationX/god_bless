package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

    private static final long TIMEOUT = 30_000L;

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 9, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        Player player3 = new Player("Test", 20, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 11, 100);
        Quest quest3 = new Quest("Test", 5, 100);

        System.out.println(player1 + " before");
        System.out.println(player2 + " before");
        System.out.println(player3 + " before");

        CompletableFuture.supplyAsync(() -> questSystem.startQuest(player1, quest1))
                .get(TIMEOUT, TimeUnit.SECONDS)
                .thenAccept(player -> System.out.println(player + " after"));

        CompletableFuture.supplyAsync(() -> questSystem.startQuest(player2, quest2))
                .orTimeout(5_000L, TimeUnit.SECONDS)
                .thenAccept(player -> System.out.println(player + " after"));

        CompletableFuture.supplyAsync(() -> questSystem.startQuest(player3, quest3))
                .get(TIMEOUT, TimeUnit.SECONDS)
                .thenAccept(player -> System.out.println(player + " after"));
    }
}
