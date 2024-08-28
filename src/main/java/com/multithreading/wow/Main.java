package com.multithreading.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        QuestSystem questSystem = new QuestSystem();


        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);


        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);
        ExecutorService service = Executors.newFixedThreadPool(3);
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1, service);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2, service);

        player1Quest.get(1, TimeUnit.MINUTES);
        player2Quest.get(1, TimeUnit.MINUTES);

        player1Quest.thenAccept(player -> System.out.println(player.getName()
                + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName()
                + " has completed the quest and now has " + player.getExperience() + " experience points."));

        service.shutdown();
    }
}
