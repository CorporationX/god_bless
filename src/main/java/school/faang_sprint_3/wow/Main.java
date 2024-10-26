package school.faang_sprint_3.wow;

public class Main {
    public static void main(String[] args) {
        var questSystem = new QuestSystem();

        var player1 = new Player("Thrall", 10, 250);
        var player2 = new Player("Sylvana", 12, 450);

        var quest1 = new Quest("Defeat the Lich King", Difficulty.HARD, 150);
        var quest2 = new Quest("Retrieve the sword of Azeroth", Difficulty.MEDIUM, 100);

        var player1Quest = questSystem.startQuest(player1, quest1);
        var player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));
    }
}
