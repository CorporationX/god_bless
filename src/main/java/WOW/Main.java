package WOW;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Player firstPlayer = Player.builder()
                .name("Thrall")
                .level(10)
                .experience(250)
                .build();
        Player secondPlayer = Player.builder()
                .name("Sylvanas")
                .level(12)
                .experience(450)
                .build();

        Quest questForFirstPlayer = Quest.builder()
                .name("Defeat the Lich King")
                .difficulty(10)
                .reward(150)
                .build();
        Quest questForSecondPlayer = Quest.builder()
                .name("Retrieve the Sword of Azeroth")
                .difficulty(8)
                .reward(100)
                .build();

        CompletableFuture<Player> firstPlayerQuest = QuestSystem.startQuest(firstPlayer, questForFirstPlayer);
        CompletableFuture<Player> secondPlayerQuest = QuestSystem.startQuest(secondPlayer, questForSecondPlayer);

        CompletableFuture.allOf(firstPlayerQuest, secondPlayerQuest).thenRun(QuestSystem::executorShutdown);

        firstPlayerQuest.thenAccept(player -> System.out.println(player.getName() + ": " + player.getLevel()
                + " has completed the quest and now has " + player.getExperience() + " experience points."));
        secondPlayerQuest.thenAccept(player -> System.out.println(player.getName() + ": " + player.getLevel()
                + " has completed the quest and now has " + player.getExperience() + " experience points."));
    }
}