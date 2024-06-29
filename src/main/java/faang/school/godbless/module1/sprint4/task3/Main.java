package faang.school.godbless.module1.sprint4.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        Player player3 = new Player("Rexar", 11, 350);
        Player player4 = new Player("Warrior", 14, 600);
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);


        List<CompletableFuture<Player>> players = new ArrayList<>();
        players.add(questSystem.startQuest(player1, quest1));
        players.add(questSystem.startQuest(player2, quest2));
        players.add(questSystem.startQuest(player3, quest1));
        players.add(questSystem.startQuest(player4, quest2));

        for (CompletableFuture<Player> player : players) {
            player.thenAccept(hero -> System.out.println(hero.getName()
                    + " has completed the quest and now has "
                    + hero.getExperience()
                    + " experience points."));
            try {
                player.get(15, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
        questSystem.shutdownAllThreads();


    }
}
