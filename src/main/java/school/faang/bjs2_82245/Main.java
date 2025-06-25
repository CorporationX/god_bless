package school.faang.bjs2_82245;

import java.util.concurrent.CompletableFuture;

import static school.faang.bjs2_82245.DifficultyQuest.EASY;
import static school.faang.bjs2_82245.DifficultyQuest.HARD;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", EASY,  150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", HARD, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));

        questSystem.breakPoolThread();
    }
}
