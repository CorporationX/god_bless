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

        CompletableFuture<Void> player1Quest = questSystem.startQuest(player1, easyQuest);
        CompletableFuture<Void> player2Quest = questSystem.startQuest(player2, mediumQuest);
        CompletableFuture<Void> player3Quest = questSystem.startQuest(player3, hardQuest);
        CompletableFuture<Void> player4Quest = questSystem.startQuest(player4, easyQuest);

        CompletableFuture<Void> allQuests = CompletableFuture.allOf(player1Quest, player2Quest, player3Quest, player4Quest);
        allQuests.join();

        questSystem.shutdown();
    }
}
