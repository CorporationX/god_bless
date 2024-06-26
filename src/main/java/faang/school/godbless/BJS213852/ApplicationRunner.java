package faang.school.godbless.BJS213852;

import java.util.concurrent.CompletableFuture;

public class ApplicationRunner {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
        questSystem.shutdown();

        //TODO:27.06.2024 не смог разобраться зачем у exceptionally делать return?
        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."))
                .exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."))
                .exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
    }
}
