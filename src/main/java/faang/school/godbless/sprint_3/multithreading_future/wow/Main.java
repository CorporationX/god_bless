package faang.school.godbless.sprint_3.multithreading_future.wow;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Player firstPlayer = new Player("Arthas", 3, 450);
        Player secondPlayer = new Player("Momon-82", 1, 999);
        Player thirdPlayer = new Player("Miranda", 5, 200);
        Quest firstQuest = new Quest("Kill the Dragon", 8, 2550);
        Quest secondQuest = new Quest("Kill camp of Goblins", 3, 550);

        QuestSystem questSystem = new QuestSystem();
        CompletableFuture<Player> firstPlayerQuestOne = questSystem.startQuest(firstPlayer, firstQuest);
        CompletableFuture<Player> secondPlayerQuestOne = questSystem.startQuest(secondPlayer, firstQuest);
        CompletableFuture<Player> thirdPlayerQuestTwo = questSystem.startQuest(thirdPlayer, secondQuest);

        firstPlayerQuestOne.thenAccept(player -> System.out.printf("%s ->  %d lvl -> %d experience.%n", player.getName(), player.getLevel(), player.getExperience()));
        secondPlayerQuestOne.thenAccept(player -> System.out.printf("%s ->  %d lvl -> %d experience.%n", player.getName(), player.getLevel(), player.getExperience()));
        thirdPlayerQuestTwo.thenAccept(player -> System.out.printf("%s ->  %d lvl -> %d experience.%n", player.getName(), player.getLevel(), player.getExperience()));
        Thread.sleep(20000);
    }
}