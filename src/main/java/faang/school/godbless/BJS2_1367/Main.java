package faang.school.godbless.BJS2_1367;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        QuestSystem questSystem = new QuestSystem();
        Player player1 = new Player("S1mple", 3, 0);
        Player player2 = new Player("Zywoo", 2, 0);
        Player player3 = new Player("Niko", 1, 0);
        Quest questEasy = new Quest("Tier-2 tournament", 3, 1000);
        Quest questMedium = new Quest("Tier-1 tournament", 5, 3000);
        Quest questHard = new Quest("Major", 7, 5000);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, questEasy);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, questMedium);
        CompletableFuture<Player> player3Quest = questSystem.startQuest(player3, questHard);
        player1Quest = questSystem.startQuest(player1, questEasy);

        player1Quest.join();
        player2Quest.join();
        player3Quest.join();

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player3Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
    }
}
