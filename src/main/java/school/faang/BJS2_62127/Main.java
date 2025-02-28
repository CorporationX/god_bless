package school.faang.BJS2_62127;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Player alex = new Player("Alex");
        Player bob = new Player("Bob");

        Quest quest1 = new Quest("Квест №1", Difficulty.HARD, 150);
        Quest quest2 = new Quest("Квест №2", Difficulty.EASY, 50);

        QuestSystem qs = new QuestSystem();

        CompletableFuture<Player> resultAlexQuest1 = qs.startQuest(alex, quest1);
        CompletableFuture<Player> resultBobQuest2 = qs.startQuest(bob, quest2);

        List<CompletableFuture<Player>> futureList = new ArrayList<>();
        futureList.add(resultAlexQuest1);
        futureList.add(resultBobQuest2);

        for (CompletableFuture<Player> result : futureList) {
            result.join();
        }

        resultAlexQuest1.thenAccept(System.out::println);
        resultBobQuest2.thenAccept(System.out::println);
    }
}
