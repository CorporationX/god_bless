package school.faang.Multithreading.sprint_4.Wow;

import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        startQuestForPlayer(questSystem, player1, quest1);
        startQuestForPlayer(questSystem, player2, quest2);
    }

    public static void startQuestForPlayer(QuestSystem questSystem, Player player, Quest quest){
        CompletableFuture<Player> playerQuest = questSystem.startQuest(player, quest);

        playerQuest.thenAccept(p -> System.out.println(p.getName() + " has completed the quest and now has "
                + p.getExperience() + " experience points.")).join();
    }
}
