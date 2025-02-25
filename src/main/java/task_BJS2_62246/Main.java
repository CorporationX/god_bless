package task_BJS2_62246;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        Player playerThrall = new Player("Thrall", 10, 250);
        Player playerSylvanas = new Player("Sylvanas", 12, 450);

        Quest questKingDefeat = new Quest("Defeat the Lich King", 10, 150);
        Quest questAzeroth = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(playerThrall, questKingDefeat);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(playerSylvanas, questAzeroth);

        player1Quest.thenAccept(player -> {
            System.out.printf("Игрок \"%s\" прошёл квест и теперь его опыт равен %d\n",
                    player.getName(), player.getExperience());
        });

        player2Quest.thenAccept(player -> {
            System.out.printf("Игрок \"%s\" прошёл квест и теперь его опыт равен %d\n",
                    player.getName(), player.getExperience());
        });
    }
}
