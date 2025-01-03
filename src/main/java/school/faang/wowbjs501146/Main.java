package school.faang.wowbjs501146;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static final int PLAYER1_LEVEL = 10;
    public static final int PLAYER1_EXPERIENCE = 250;
    public static final int PLAYER2_LEVEL = 12;
    public static final int PLAYER2_EXPERIENCE = 450;

    public static final int QUEST1_DIFFICULTY = 10;
    public static final int QUEST1_REWARD = 150;
    public static final int QUEST2_DIFFICULTY = 8;
    public static final int QUEST2_REWARD = 100;

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", PLAYER1_LEVEL, PLAYER1_EXPERIENCE);
        Player player2 = new Player("Sylvanas", PLAYER2_LEVEL, PLAYER2_EXPERIENCE);

        Quest quest1 = new Quest("Defeat the Lich King", QUEST1_DIFFICULTY, QUEST1_REWARD);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", QUEST2_DIFFICULTY, QUEST2_REWARD);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player ->
                System.out.println(player.getName() + " has completed the quest and now has "
                        + player.getExperience() + " experience points"));
        player2Quest.thenAccept(player ->
                System.out.println(player.getName() + " has completed the quest and now has "
                        + player.getExperience() + " experience points"));

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }
}
