package faang.school.godbless.WOW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> playerAfter = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 * quest.getDifficulty());
                return player;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        playerAfter.join();
        return playerAfter;
    }

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        Player player1 = new Player("Rob", 1, 1);
        Player player2 = new Player("Arthas", 99, 2000);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 15);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 10);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed quest and now has: " + player.getExperience() + " experience points"));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed quest and now has: " + player.getExperience() + " experience points"));
    }
}

