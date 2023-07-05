package faang.school.godbless.Sprint5_1.task3;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(player.getName() + " started the quest: " + quest.getName());
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 5, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 2, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player ->
                System.out.println(player.getName() + " has completed the quest and now has "
                        + player.getExperience() + " experience points.")).join();

        player2Quest.thenAccept(player ->
                System.out.println(player.getName() + " has completed the quest and now has "
                        + player.getExperience() + " experience points.")).join();
    }
}
