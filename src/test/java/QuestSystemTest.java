import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.bjs250134.Player;
import school.faang.bjs250134.Quest;
import school.faang.bjs250134.QuestSystem;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class QuestSystemTest {
    QuestSystem questSystem = new QuestSystem();

    @Test
    void testSinglePlayerExecuteQuest() throws ExecutionException, InterruptedException {
        Player player = new Player("Thrall", 10, 250);
        Quest quest = new Quest("'Defeat the Lich King'", 10, 150);

        CompletableFuture<Player> playerCompleteQuest = questSystem.startQuest(player, quest);

        Assertions.assertEquals(350, playerCompleteQuest.get().getExperience());
    }

    @Test
    void testMultiplyPlayerExecuteQuest() throws ExecutionException, InterruptedException {
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("'Defeat the Lich King'", 10, 150);
        Quest quest2 = new Quest("'Retrieve the Sword of Azeroth'", 5, 100);

        CompletableFuture<Player> player1CompleteQuest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2CompleteQuest = questSystem.startQuest(player2, quest2);

        Assertions.assertEquals(350, player1CompleteQuest.get().getExperience());
        Assertions.assertEquals(460, player2CompleteQuest.get().getExperience());
    }
}
