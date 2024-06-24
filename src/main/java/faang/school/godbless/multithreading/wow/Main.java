package faang.school.godbless.multithreading.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Jaina", 12, 300);
        Player player3 = new Player("Arthas", 15, 350);
        Player player4 = new Player("Illidan", 18, 400);
        Player player5 = new Player("Sylvanas", 20, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 1, 150);
        Quest quest2 = new Quest("Retrieve the Lost Artifact", 2, 200);
        Quest quest3 = new Quest("Save the Village", 4, 250);
        Quest quest4 = new Quest("Slay the Dragon", 5, 300);
        Quest quest5 = new Quest("Find the Hidden Treasure", 6, 350);

        var playerCompletableFuture1 = questSystem.startQuest(player1, quest1);
        var playerCompletableFuture2 = questSystem.startQuest(player2, quest2);
        var playerCompletableFuture3 = questSystem.startQuest(player3, quest3);
        var playerCompletableFuture4 = questSystem.startQuest(player4, quest4);
        var playerCompletableFuture5 = questSystem.startQuest(player5, quest5);

        var playerLevelAndExperienceUp = playerCompletableFuture1.thenApply(player -> {
            player.setLevel(player.getLevel() + 1);
            player.setExperience(player.getExperience() + 10);
            return player;
        });

        CompletableFuture<Void> playerCompletedQuest = playerCompletableFuture5.thenAccept(player -> {
            System.out.printf("%s has completed quest.", player.getName());
        });

        var player2StartsNewQuest = playerCompletableFuture2.thenCompose(player ->
                questSystem.startQuest(player, quest3));

        var playersCompletedQuests = playerCompletableFuture3.thenCombine(playerCompletableFuture4, (p1, p2) -> {
            System.out.printf("%s and %s have completed their quests.\n", p1.getName(), p2.getName());
            return null;
        });

        CompletableFuture.allOf(playerLevelAndExperienceUp, player2StartsNewQuest, playersCompletedQuests).join();
    }
}
