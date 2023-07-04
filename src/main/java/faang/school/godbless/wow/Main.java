package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> completableFuture1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> completableFuture2 = questSystem.startQuest(player2, quest2);

        completableFuture1.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));
        completableFuture2.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));
    }
}
