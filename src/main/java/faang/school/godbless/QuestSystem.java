package faang.school.godbless;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    ExecutorService executor;

    public QuestSystem() {
        executor = Executors.newFixedThreadPool(1);
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

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(player.getName() + " is starting the quest: " + quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000);
                int reward = quest.getReward();
                int currentExp = player.getExperience();
                int newExp = currentExp + reward;
                player.setExperience(newExp);
                System.out.println(player.getName() + " has completed the quest: " + quest.getName());
                System.out.println(player.getName() + " received " + reward + " experience points.");
                return player;
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        });
    }
}
