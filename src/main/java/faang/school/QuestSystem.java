package faang.school;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        var resulst = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
        return resulst;
    }

    public static void main(String[] args) throws InterruptedException {
        QuestSystem questSystem = new QuestSystem();

        Player John = new Player("John", 10, 0);
        Player Alice = new Player("Alice", 5, 0);
        Quest Dragon = new Quest("Defeat the Dragon", 8, 500);
        Quest Flowers = new Quest("Collect 10 Rare Flowers", 5, 200);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(John, Dragon);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(Alice, Flowers);

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

        Thread.sleep(3000);
    }
}
