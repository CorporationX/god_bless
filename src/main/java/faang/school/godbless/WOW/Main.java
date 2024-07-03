package faang.school.godbless.WOW;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Player 1", 1, 0);
        Player player2 = new Player("Player 2", 2, 3);
        Player player3 = new Player("Player 3", 1, 5);
        Player player4 = new Player("Player 4", 3, 20);
        Player player5 = new Player("Player 5", 3, 15);

        Quest task1 = new Quest("Task 1", 10, 5);
        Quest task2 = new Quest("Task 2", 15, 10);
        Quest task3 = new Quest("Task 3", 5, 25);

        questSystem.startQuest(player1, task1);
        questSystem.startQuest(player2, task2);
        questSystem.startQuest(player3, task3);
        questSystem.startQuest(player4, task2);
        questSystem.startQuest(player5, task1);

    }
}
