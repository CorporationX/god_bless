package school.faang.task_50158;

public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        Player player3 = new Player("Anya", 8, 200);
        Player player4 = new Player("Vanya", 14, 500);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);
        Quest quest3 = new Quest("doing nothing", 6, 80);
        Quest quest4 = new Quest("doing something", 12, 170);

        questSystem.startQuest(player1, quest1);
        questSystem.startQuest(player2, quest2);
        questSystem.startQuest(player3, quest3);
        questSystem.startQuest(player4, quest4);
    }
}