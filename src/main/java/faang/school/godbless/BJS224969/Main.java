package faang.school.godbless.BJS224969;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player rexar = new Player("Rexar", 6, 6000L);
        Player admiralProudmoore = new Player("Admiral Proudmoore", 25, 25000L);

        Quest searchForJaina = new Quest("Search for Jaina", 5, 5000L);
        Quest portDefense = new Quest("Port Defense", 10, 10000L);

        CompletableFuture<Player> rexarFuture = questSystem.startQuest(rexar, searchForJaina);
        CompletableFuture<Player> admiralProudmooreFuture = questSystem.startQuest(admiralProudmoore, portDefense);

        rexarFuture.thenAccept(player -> System.out.println(player.getName() + " completed quest: " +
                searchForJaina.getName() + " and gained " + searchForJaina.getReward() + " experience"));

        admiralProudmooreFuture.thenAccept(player -> System.out.println(player.getName() + " completed quest: " +
                portDefense.getName() + " and gained " + portDefense.getReward() + " experience"));

        CompletableFuture.allOf(rexarFuture, admiralProudmooreFuture).join();
    }
}
