package faang.school.godbless.sprint5.wow;

import faang.school.godbless.sprint5.wow.classes.Player;
import faang.school.godbless.sprint5.wow.classes.Quest;
import faang.school.godbless.sprint5.wow.classes.QuestSystem;
import faang.school.godbless.sprint5.wow.enums.Difficult;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem system = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);


        Quest quest1 = new Quest("Defeat the Lich King", Difficult.LEGENDARY, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", Difficult.MEDIUM, 100);

        CompletableFuture<Player> player1Quest = system.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = system.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

    }
}
