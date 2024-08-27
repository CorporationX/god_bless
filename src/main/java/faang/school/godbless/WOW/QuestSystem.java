package faang.school.godbless.WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {
    ExecutorService executor = Executors.newFixedThreadPool(1);
        return CompletableFuture.supplyAsync(() -> player,executor)
                .thenApplyAsync(p -> {
                    try {
                        Thread.sleep(quest.getDifficulty() * 1000);
                    } catch (InterruptedException e) {
                        throw new IllegalStateException("Quest execution interrupted", e);
                    }
                    return p;
                }, executor)
                .thenApplyAsync(p -> {
                    p.addExperience(quest.getDifficulty() * 10);
                    return p;
                }, executor)
                .exceptionally(ex -> {
                    System.out.println("Quest failed: " + ex.getMessage());
                    return player;
                });
    }

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
    }
}
