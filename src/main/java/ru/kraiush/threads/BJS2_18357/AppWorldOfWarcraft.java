package ru.kraiush.threads.BJS2_18357;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class AppWorldOfWarcraft {

    public static void main(String[] args) {

        String[] playerNames = {"Apollo", "Sharon"};

        String[] questes = {"look for the Kladenets sword", "hide in the invisibility cloak", "throw the wizard's hat"};

        List<Player> listOfPlayers = new ArrayList<>();
        List<Quest> listOfQuests = new ArrayList<>();

        for (int i = 0; i < playerNames.length; i++) {
            listOfPlayers.add(new Player(playerNames[i], ThreadLocalRandom.current().nextInt(1, 50), ThreadLocalRandom.current().nextInt(1, 500)));
        }

        for (int i = 0; i < questes.length; i++) {
            listOfQuests.add(new Quest(questes[i], ThreadLocalRandom.current().nextInt(1, 10), ThreadLocalRandom.current().nextInt(1, 100)));
        }
        listOfPlayers.forEach(System.out::println);
        listOfQuests.forEach(System.out::println);

        QuestSystem system = new QuestSystem();
        System.out.println("\nStart quests!");

        for (int i = 0; i < listOfPlayers.size(); i++) {
            for (int j = 0; j < listOfQuests.size(); j++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(listOfQuests.get(j).getDifficulty() * 1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Thread Interrupted - " + Thread.currentThread().getName());
                }
                System.out.println("player's experience before the quest: " + listOfPlayers.get(i).getExperience());
                CompletableFuture<Player> o = system.combineItems(listOfPlayers.get(i), listOfQuests.get(j));
                o.thenAccept(player -> System.out.println("player {" + player.getName() + "} has completed the quest and now has " + player.getExperience() + " experience points."));
            }
        }
    }
}
