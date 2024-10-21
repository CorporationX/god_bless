package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        Quest easyQuest = new Quest("Catch a Drunk", "Easy", 250);
        Quest mediumQuest = new Quest("Kill Yaitsslav", "Medium", 500);
        Quest hardQuest = new Quest("Become a Java Developer", "Hard", 1000);

        Player player1 = new Player("Dmitry", 2, 300);
        Player player2 = new Player("Kirill", 5, 563);
        Player player3 = new Player("Ruslan", 10, 2450);
        Player player4 = new Player("Maksim", 3, 365);

        CompletableFuture<Player> player1Quest1 = questSystem.startQuest(player1, easyQuest);
        CompletableFuture<Player> player2Quest1 = questSystem.startQuest(player2, mediumQuest);
        CompletableFuture<Player> player3Quest1 = questSystem.startQuest(player3, hardQuest);
        CompletableFuture<Player> player4Quest1 = questSystem.startQuest(player4, easyQuest);

        player1Quest1.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest1.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player3Quest1.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player4Quest1.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        questSystem.shutdown();
    }
}
