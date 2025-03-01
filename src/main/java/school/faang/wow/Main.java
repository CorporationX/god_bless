package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player thrall = new Player("Thrall", 10, 250);
        Player sylvana = new Player("Sylvana", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(thrall, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(sylvana, quest2);

        showUpdatedExperience(player1Quest);
        showUpdatedExperience(player2Quest);

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }

    private static void showUpdatedExperience(CompletableFuture<Player> completableFuture) {
        completableFuture.thenAccept(player ->
                log.info("Опыт игрока {} теперь == {}", player.getName(), player.getExperience()));
    }
}
