package school.faang.m1.future.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem implements AutoCloseable {

    private final ExecutorService exec = Executors.newFixedThreadPool(
            Math.max(2, Runtime.getRuntime().availableProcessors() / 2),
            r -> {
                Thread t = new Thread(r, "quest-exec");
                t.setDaemon(true);
                return t;
            }
    );

    private static void simulateQuestWork(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Quest interrupted", e);
        }
    }

    CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            simulateQuestWork(quest.getDifficulty() * 100);
            player.gainExperience(quest.getReward());
            player.applyReward(quest.getReward());
            return player;

        }, exec);
    }

    public static void main(String[] args) throws Exception {
        try (QuestSystem questSystem = new QuestSystem()) {

            Player player1 = new Player("Thrall", 10, 250);
            Player player2 = new Player("Sylvanas", 12, 450);

            Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
            Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

            CompletableFuture<Player> player1Quest1 = questSystem.startQuest(player1, quest1);
            CompletableFuture<Player> player2Quest1 = questSystem.startQuest(player2, quest2);
            CompletableFuture<Player> player1Quest2 = questSystem.startQuest(player1, quest2);

            player1Quest1.thenAccept(player -> System.out.println(player.getName()
                    + " has completed the quest and now has " + player.getExperience()
                    + " experience points. Lvl: " + player.getLevel()));
            player2Quest1.thenAccept(player -> System.out.println(player.getName()
                    + " has completed the quest and now has " + player.getExperience()
                    + " experience points. Lvl: " + player.getLevel()));
            player1Quest2.thenAccept(player -> System.out.println(player.getName()
                    + " has completed the quest and now has " + player.getExperience()
                    + " experience points. Lvl: " + player.getLevel()));

            CompletableFuture<Void> allDone =
                    CompletableFuture.allOf(player1Quest1, player2Quest1, player1Quest2);
            allDone.join();
        }
    }

    @Override
    public void close() {
        exec.shutdown();
    }
}
