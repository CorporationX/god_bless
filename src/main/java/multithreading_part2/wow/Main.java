package multithreading_part2.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        QuestSystem questSystem = new QuestSystem();
        Player sam = new Player("Sam", 6, 10);
        Player artem = new Player("Artem", 7, 50);

        Quest quest1 = new Quest("quest1", 10, 100);
        Quest quest2 = new Quest("quest2", 3, 50);

        CompletableFuture<Player> samCompletableFuture = questSystem.startQuest(sam, quest1);
        CompletableFuture<Player> artemCompletableFuture = questSystem.startQuest(artem, quest2);
        samCompletableFuture
                .thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "+ player.getExperience() + " experience points."));
        artemCompletableFuture
                .thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "+ player.getExperience() + " experience points."));
        Thread.sleep(1000);
    }
}
