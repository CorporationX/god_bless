package bjs2_37879;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        PlayerQuest playerQuest1 = new PlayerQuest(player1, quest1);
        PlayerQuest playerQuest2 = new PlayerQuest(player2, quest2);
        List<PlayerQuest> playerQuests = List.of(playerQuest1, playerQuest2);

        questSystem.processAllPlayerQuests(playerQuests);
    }
}
