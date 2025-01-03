package school.faang.bjs250114;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        Player player3 = new Player("Jaina", 15, 600);
        Player player4 = new Player("Arthas", 20, 800);
        Player player5 = new Player("Illidan", 18, 700);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);
        Quest quest3 = new Quest("Conquer the Black Temple", 12, 200);
        Quest quest4 = new Quest("Defend the Undercity", 15, 250);
        Quest quest5 = new Quest("Explore the Emerald Dream", 20, 300);

        CompletableFuture<Player> player1Quest1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest2 = questSystem.startQuest(player2, quest2);
        CompletableFuture<Player> player3Quest3 = questSystem.startQuest(player3, quest3);
        CompletableFuture<Player> player4Quest4 = questSystem.startQuest(player4, quest4);
        CompletableFuture<Player> player5Quest5 = questSystem.startQuest(player5, quest5);

        questSystem.handleQuestCompletion(player1Quest1, player1);
        questSystem.handleQuestCompletion(player2Quest2, player2);
        questSystem.handleQuestCompletion(player3Quest3, player3);
        questSystem.handleQuestCompletion(player4Quest4, player4);
        questSystem.handleQuestCompletion(player5Quest5, player5);

        player1Quest1.join();
        player2Quest2.join();
        player3Quest3.join();
        player4Quest4.join();
        player5Quest5.join();

    }
}