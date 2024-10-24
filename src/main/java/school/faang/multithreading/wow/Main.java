package school.faang.multithreading.wow;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Ork", 3, 250);
        Player player2 = new Player("Elf", 1, 50);
        Player player3 = new Player("Wizard", 2, 200);
        Player player4 = new Player("Knight", 4, 300);

        Quest quest1 = new Quest("Find gold", 3, 150);
        Quest quest2 = new Quest("Danger", 5, 250);
        Quest quest3 = new Quest("Power of magic", 2, 100);
        Quest quest4 = new Quest("Kill them all", 7, 350);
        Quest quest5 = new Quest("More treasures", 1, 50);

        CompletableFuture<Player> player1quest1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2quest2 = questSystem.startQuest(player2, quest2);
        CompletableFuture<Player> player3quest3quest5 = questSystem.startQuest(player3, quest3)
                .thenComposeAsync(player -> questSystem.startQuest(player, quest5));
        CompletableFuture<Player> player4quest4 = questSystem.startQuest(player4, quest4);

        player1quest1.thenAccept(player -> System.out.println(
                player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2quest2.thenAccept(player -> System.out.println(
                player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player3quest3quest5.thenAccept(player -> System.out.println(
                player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player4quest4.thenAccept(player -> System.out.println(
                player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
    }
}
