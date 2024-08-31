package faang.school.godbless.WOW;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        QuestSystem questSystem = new QuestSystem(executorService);

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> log.info(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> log.info(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));


        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS))
                executorService.shutdownNow();
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }


    }
}
