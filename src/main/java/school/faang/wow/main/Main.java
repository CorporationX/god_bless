package school.faang.wow.main;

import school.faang.wow.main_code.Player;
import school.faang.wow.main_code.Quest;
import school.faang.wow.main_code.QuestSystem;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Gadzhi", 2, 20);
        Player player2 = new Player("Vlad", 4, 40);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> future1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> future2 = questSystem.startQuest(player2, quest2);

        future1.thenAccept(player -> System.out.println(player.getName() +
                " has completed the quest and now has " + player.getExperience() + " experience points."));
        future2.thenAccept(player -> System.out.println(player.getName() +
                " has completed the quest and now has " + player.getExperience() + " experience points."));
    }
}
