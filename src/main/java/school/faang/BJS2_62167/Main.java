package school.faang.BJS2_62167;

public class Main {

    public static void main(String[] args) {
        QuestSystem qs = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        qs.startQuest(player1, quest1);
        qs.startQuest(player2, quest2);

        qs.waitForCompletionQuest();
        QuestSystem.shutdown();
    }
}
