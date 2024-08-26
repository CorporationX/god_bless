package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

    private static final long TIMEOUT = 10_000L;

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 9, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 11, 100);

        System.out.println(player1 + " before");
        System.out.println(player2 + " before");

        CompletableFuture.supplyAsync(() -> questSystem.startQuest(player1, quest1))
                .get(TIMEOUT, TimeUnit.SECONDS)
                .thenAccept(player -> System.out.println(player + " after"));

        CompletableFuture.supplyAsync(() -> questSystem.startQuest(player2, quest2))
                .get(TIMEOUT, TimeUnit.SECONDS)
                .thenAccept(player -> System.out.println(player + " after"));
    }
}
