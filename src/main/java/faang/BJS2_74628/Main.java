package faang.BJS2_74628;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        final Player firstPlayer = new Player("Daniyal", 1);
        final Player secondPlayer = new Player("Eva", 2);

        final Quest quest = new Quest("First", 3, 5);
        final Quest quest2 = new Quest("Second", 4, 6);

        final QuestSystem questSystem = new QuestSystem();

        CompletableFuture<Void> firstPlayerTask = questSystem.startQuest(firstPlayer, quest)
                .thenApply(Player::getExperience)
                .thenAccept(experience -> System.out.println("Experience: " + experience));

        CompletableFuture<Void> secondPlayerTask = questSystem.startQuest(secondPlayer, quest2)
                .thenApply(Player::getExperience)
                .thenAccept(experience -> System.out.println("Experience: " + experience));

        CompletableFuture.allOf(firstPlayerTask, secondPlayerTask).join();
    }
}

