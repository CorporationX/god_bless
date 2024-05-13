package faang.school.godbless.wow;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSys = new QuestSystem();
        List<Player> players = List.of(new Player("badBoy", 1, 50)
                , new Player("megaton", 5, 150), new Player("Prime", 10, 1000));
        List<Quest> quests = List.of(new Quest("Find mushrooms", "easy", 15)
                , new Quest("cooking chocolate", "easy", 10)
                , new Quest("Kill Megalodon", "very hard", 1000000));
        players.forEach(player -> quests.forEach(quest -> {
            CompletableFuture<Player> playerCompletableFuture;
            try {
                playerCompletableFuture = questSys.startQuest(player, quest);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            playerCompletableFuture.thenAccept(playerFuture ->
                    System.out.printf("Player %s completed the task %s for this the player is credited %d points. Total points after completing this mission: %d%n", playerFuture.getName(), quest.getName(), quest.getReward(), playerFuture.getExperience()));
        }));
    }
}
