package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest){

        CompletableFuture<Player> futurePlayer = new CompletableFuture<>();

        try {
            System.out.println(player.getName() + " has started a quest " + quest.getName());
            Thread.sleep(quest.getDifficulty());
            System.out.println(player.getName() + " has finished the quest " + quest.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        player.setExperience(player.getExperience() + quest.getReward());

        futurePlayer.complete(player);

        return futurePlayer;
    }

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> System.out.println(player.getName() +
                " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() +
                " has completed the quest and now has " + player.getExperience() + " experience points."));
    }
}
