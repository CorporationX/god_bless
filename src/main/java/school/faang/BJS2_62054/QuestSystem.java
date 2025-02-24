package school.faang.BJS2_62054;

import lombok.NonNull;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(@NonNull Player player, @NonNull Quest quest) {
        CompletableFuture<Player> playerQuest = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * quest.difficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return player;
        });

        playerQuest.thenApply(p -> {
            int newExperience = p.getExperience() + quest.reward();
            p.setExperience(newExperience);
            return p;
        });
        playerQuest.exceptionally(throwable -> {
            System.err.println("Error: " + throwable.getCause().getMessage());
            return null;
        });
        playerQuest.join();

        return playerQuest;
    }

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Piter", 10, 250);
        Player player2 = new Player("Andrey", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> System.out.println(
                "%s has completed the quest and now has %d experience points."
                        .formatted(player.getName(), player.getExperience())));
        player2Quest.thenAccept(player -> System.out.println(
                "%s has completed the quest and now has %d experience points."
                        .formatted(player.getName(), player.getExperience())));

    }
}
