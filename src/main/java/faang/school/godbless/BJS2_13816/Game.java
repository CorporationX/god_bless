package faang.school.godbless.BJS2_13816;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Game {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
// create players
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
// create quests
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);
//launch async increasing player's experience
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
//when player will finish quest write the message
        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
//Не знаю как в данном случае сказать что потоки больше создавать не нужно и можно завершить программу.
        CompletableFuture<Void> doneTask = CompletableFuture.allOf(player1Quest, player2Quest);
        try {
            doneTask.thenRun(() -> {
                questSystem.stopThreadPool(questSystem.getService());
            }).get(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.getStackTrace();
        }
    }
}
