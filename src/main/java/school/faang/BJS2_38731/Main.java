package school.faang.BJS2_38731;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Vovohka", 11, 500);
        Player player2 = new Player("MaxFrai", 15, 1000);

        Quest quest1 = new Quest("Save westeros", 11, 1000);
        Quest quest2 = new Quest(" Get the bow ", 14, 1500);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> System.out.println(player.getName() + "ended quest and now got " + player.getExperience() + " exp points "));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + "ended quest and now got " + player.getExperience() + "  exp points "));
    }
}
