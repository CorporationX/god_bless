package faang.school.godbless.fourth.Wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", Difficulty.HARD, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", Difficulty.MEDIUM, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenApply(player -> {
            player.upLevel();
            return player;
        }).thenAccept(player -> System.out.println("Player " + player.getName()
                + " now has " + player.getLevel() + " lvl and " + player.getExperience() + " exp.")).join();

        player2Quest.thenAccept(player -> System.out.println("Player " + player.getName()
                + " now has " + player.getLevel() + " lvl and " + player.getExperience() + " exp.")).join();
    }
}
