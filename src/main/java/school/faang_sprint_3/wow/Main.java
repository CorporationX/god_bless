package school.faang_sprint_3.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    private final QuestSystem questSystem = new QuestSystem();

    public static void main(String[] args) {
        Main main = new Main();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvana", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", Difficulty.HARD, 150);
        Quest quest2 = new Quest("Retrieve the sword of Azeroth", Difficulty.MEDIUM, 100);

        main.startAndPrint(player1, quest1);
        main.startAndPrint(player2, quest1);
        main.startAndPrint(player1, quest2);
        main.startAndPrint(player2, quest2);

    }

    private void startAndPrint(Player player, Quest quest) {
        CompletableFuture<Player> futurePlayer = questSystem.startQuest(player, quest);
        futurePlayer.thenAccept(p -> System.out.println(p.getName() + " has completed the quest and now has "
                + p.getExperience() + " experience points."));
    }

}

