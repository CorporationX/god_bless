package BJS262156;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem qs = new QuestSystem();

        Player firstPlayer = new Player("Goga", 10, 300);
        Player secondPlayer = new Player("Goga`s friend", 1, 20);

        Quest easyQuest = new Quest("Under Ground", 1, 25);
        Quest mediumQuest = new Quest("Upper Ground", 5, 125);

        CompletableFuture<Player> firstQuest = qs.startQuest(secondPlayer, easyQuest);
        CompletableFuture<Player> secondQuest = qs.startQuest(firstPlayer, mediumQuest);

        firstQuest.thenAccept(Main::acceptResult);
        secondQuest.thenAccept(Main::acceptResult);

        firstQuest.join();
        secondQuest.join();
    }

    private static void acceptResult(Player player) {
        System.out.println(player.getName() +
                " has completed the quest and now has " + player.getExperience()
                + " experience points.");
    }
}
