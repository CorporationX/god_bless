package school.faang.bjs2_74593;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Player> listOfPlayers = new ArrayList<>();
        listOfPlayers.add(new Player("Nick", 1, 0));
        listOfPlayers.add(new Player("Marina", 2, 2));
        listOfPlayers.add(new Player("Vova", 59, 1));

        List<Quest> listOfQuests = new ArrayList<>();
        listOfQuests.add(new Quest("Kill Onyxia", DifficultyLevel.MYTHIC, 20));
        listOfQuests.add(new Quest("Kill Lich King", DifficultyLevel.MYTHIC, 20));
        listOfQuests.add(new Quest("Kill Gnoll", DifficultyLevel.EASY, 2));
        listOfQuests.add(new Quest("Kill Defias gang member", DifficultyLevel.NORMAL, 5));
        listOfQuests.add(new Quest("Kill Opera in Karazhan", DifficultyLevel.HEROIC, 15));

        QuestSystem questSystem = new QuestSystem();
        ExecutorService executorService = questSystem.getExecutor();
        List<CompletableFuture<Player>> futures = new ArrayList<>();

        for (Player player : listOfPlayers) {
            for (Quest quest : listOfQuests) {
                futures.add(questSystem.startQuest(player, quest));
            }
        }
        futures.forEach(CompletableFuture::join);
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(50, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted while shutting down", e);
        }
    }
}
