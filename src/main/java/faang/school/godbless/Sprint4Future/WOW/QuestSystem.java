package faang.school.godbless.Sprint4Future.WOW;

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

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

        player1Quest.join();
        player2Quest.join();
    }
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        int currentPlayerStrength = player.getLevel() + player.getExperience();
        int timeToCompleteQuestInMillis = (quest.difficulty() * 1000) - currentPlayerStrength;
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Completing quest... by: " + player.getName());
                Thread.sleep(timeToCompleteQuestInMillis);
                player.setExperience(player.getExperience() + quest.reward());
                return player;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
