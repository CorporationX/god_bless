package school.faang.BJS2_63994;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem quest = new QuestSystem();

        Player ramil = new Player("Ramil", 10, 100);
        Player albert = new Player("Albert", 11, 200);

        Quest defeatLichKing = new Quest("Defeat the Lich King", 10, 5);
        Quest retrieveSword = new Quest("Retrieve the Sword of Azeroth", 8, 10);

        CompletableFuture<Player> ramilQuest = quest.startQuest(ramil, defeatLichKing);
        CompletableFuture<Player> albertQuest = quest.startQuest(albert, retrieveSword);

        CompletableFuture.allOf(ramilQuest, albertQuest).join();

        ramilQuest.thenAccept(player ->
                System.out.printf("%n%s has completed the quest and now has %s experience points.",
                        player.getName(), player.getExperience())
        );

        albertQuest.thenAccept(player ->
                System.out.printf("%n%s has completed the quest and now has %s experience points.",
                        player.getName(), player.getExperience())
        );


    }
}
