package school.faang.s_4_1_wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Ark");
        Player player2 = new Player("George");
        Player player3 = new Player("Anti George");
        Quest quest = new Quest("Battle Jack", 1, 50);
        QuestSystem questSystem = new QuestSystem();
        CompletableFuture<Player> player1ended = questSystem.startQuest(player1, quest);
        CompletableFuture<Player> player2ended = questSystem.startQuest(player2, quest);
        CompletableFuture.allOf(player1ended, player2ended)
                .thenRun(() -> {
                    Player player1updated = player1ended.join();
                    Player player2updated = player2ended.join();
                    System.out.println("Quest " + quest.getName() + " completed");
                    System.out.println("player " + player1updated.getName() + " updated");
                    System.out.println("player " + player2updated.getName() + " updated");
                }).join();
    }
}
