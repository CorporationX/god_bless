package faang.school.godbless.kxnvg.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

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

        player1Quest.join();
        player2Quest.join();
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> futurePlayer = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 * quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            player.setLevel(player.getLevel() + 1);
            return player;
        });
        return futurePlayer;
    }
}
