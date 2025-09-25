package school.faang.future_completable_future.bjs2_92579;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    @SuppressWarnings("checkstyle:CommentsIndentation")
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        QuestSystem.stopQuestProcessingAndAwaitTermination();

        player1Quest.thenAccept(Main::printMessage);
        player2Quest.thenAccept(Main::printMessage);
    }

    private static void printMessage(Player player) {
        log.info("{} ты выполнил квест, {} твой опыт увеличился.",
                player.getName().toUpperCase(), player.getExperience());
    }
}