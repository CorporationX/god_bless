package school.faang.BJS238491;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    private static final int THREADS = 2;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(THREADS);
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> questCompletableFuture = CompletableFuture.supplyAsync(() -> player, EXECUTOR_SERVICE);
        {
            questCompletableFuture.thenApply(q -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    log.error("Something went wrong " + e);
                }
                int reward = quest.getReward();
                player.setExperience(reward);
                return player;
            });
            return questCompletableFuture;
        }
    }

    public void shutDown() {
        EXECUTOR_SERVICE.shutdown();
    }

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
        player1Quest.join();
        player2Quest.join();
        questSystem.shutDown();

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

    }
}
