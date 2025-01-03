package school.faang.sprint_4.task_50036;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 250);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 300);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.join();
        player2Quest.join();

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points and level " + player.getLevel()));

        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points and level " + player.getLevel()));

    }
}
