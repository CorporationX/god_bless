package faang.school.godbless.sprint4.wow;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem system = new QuestSystem();
        Player p1 = new Player("Edward228", 1, 500);
        Player p2 = new Player("Nathan007", 4, 4999);
        Player p3 = new Player("James187", 6, 4500);

        Quest q1 = new Quest("Training Fight", 2, 2000);
        Quest q2 = new Quest("Medium Fight", 4, 5000);
        Quest q3 = new Quest("Boss Fight", 6, 10000);

        List<CompletableFuture<Player>> futures = Arrays.asList(
                system.startQuest(p1, q1),
                system.startQuest(p2, q2),
                system.startQuest(p3, q3)
        );

        futures.forEach(cf -> cf.whenComplete((result, throwable) -> {
            if (throwable != null) {
                System.err.println("Player hasn't passed the quest - " + throwable.getMessage());
            } else {
                System.out.println("Player passed the quest, new stats: " + result);
            }
        }));

        try {
            CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        } catch (Exception e) {
            System.err.println("An error occurred while waiting for all futures: " + e.getMessage());
        }
    }
}
