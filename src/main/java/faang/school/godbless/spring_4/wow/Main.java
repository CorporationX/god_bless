package faang.school.godbless.spring_4.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Quest quest1 = new Quest("Collect orcs", 8, 100);
        Quest quest2 = new Quest("Find the Crystal of Happiness", 10, 1000);

        Player inna = new Player("Inna", 10, 250);
        Player pavel = new Player("Pavel", 9, 300);

        QuestSystem system = new QuestSystem();

        CompletableFuture<Player> player1Quest = system.startQuest(inna, quest1);
        CompletableFuture<Player> player2Quest = system.startQuest(pavel, quest2);

        player1Quest.thenAccept(player -> System.out.printf("%s has completed the quest and now has %s \n", player.getName()
                , player.getExperience()));
        player2Quest.thenAccept(player -> System.out.printf("%s has completed the quest and now has %s \n", player.getName()
                , player.getExperience()));

        system.pool.shutdown();
    }
}
