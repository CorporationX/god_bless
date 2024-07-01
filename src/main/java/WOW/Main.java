package WOW;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Player firstPlayer = new Player("Thrall", 10, 250);
        Player secondPlayer = new Player("Sylvanas", 12, 450);

        Quest questForFirstPlayer = new Quest("Defeat the Lich King", 10, 150);
        Quest questForSecondPlayer = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> firstPlayerQuest = QuestSystem.startQuest(firstPlayer, questForFirstPlayer);
        CompletableFuture<Player> secondPlayerQuest = QuestSystem.startQuest(secondPlayer, questForSecondPlayer);

        firstPlayerQuest.thenAccept(player -> System.out.println(player.getName() + ": " + player.getLevel()
                + " has completed the quest and now has " + player.getExperience() + " experience points."));
        secondPlayerQuest.thenAccept(player -> System.out.println(player.getName() + ": " + player.getLevel()
                + " has completed the quest and now has " + player.getExperience() + " experience points."));
    }
}