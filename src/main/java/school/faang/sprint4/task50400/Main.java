package school.faang.sprint4.task50400;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint4.task50400.model.Player;
import school.faang.sprint4.task50400.model.Quest;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("Fedor", 15, 250);
        Player player2 = new Player("Matroskin", 12, 200);
        Player player3 = new Player("Sharik", 10, 150);

        Quest quest1 = new Quest("Hunting", 10, 100);
        Quest quest2 = new Quest("Photo Hunting", 8, 50);
        Quest quest3 = new Quest("Fix the TV", 6, 30);

        QuestSystem questSystem = new QuestSystem();

        CompletableFuture<Player> futurePlayer1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> futurePlayer2 = questSystem.startQuest(player2, quest2);
        CompletableFuture<Player> futurePlayer3 = questSystem.startQuest(player3, quest3);

        futurePlayer1.thenAccept(player -> log.info("Player {} finishes quest {} and get {} of experience. "
                        + "His experience now is: {}",
                player1.getName(), quest1.getName(), quest1.getReward(), player1.getExperience().get()));

        futurePlayer2.thenAccept(player -> log.info("Player {} finishes quest {} and get {} of experience. "
                        + "His experience now is: {}",
                player2.getName(), quest2.getName(), quest2.getReward(), player2.getExperience().get()));

        futurePlayer3.thenAccept(player -> log.info("Player {} finishes quest {} and get {} of experience. "
                        + "His experience now is: {}",
                player3.getName(), quest3.getName(), quest3.getReward(), player3.getExperience().get()));

        questSystem.finishWork();


    }
}
